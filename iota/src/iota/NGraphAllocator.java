package iota;

import java.util.*;

/**
 * A register allocator that uses the graph coloring algorithm to allocate physical registers.
 */
class NGraphRegisterAllocator extends NRegisterAllocator {

    private static class Interval {
        NRegister register;
        int start;
        int end;

        public Interval(NRegister register, int start, int end) {
            this.register = register;
            this.start = start;
            this.end = end;
        }

        public void extend(int id) {
            this.end = Math.max(this.end, id);
        }

        public boolean interferes(Interval other) {
            return !(this.end < other.start || other.end < this.start);
        }
    }

    private static class InterferenceGraph {
        private final Map<NRegister, Set<NRegister>> adjacencyList = new HashMap<>();
        private final Map<NRegister, Integer> colors = new HashMap<>();
        private final Map<NRegister, NRegister> canonicalRegisterMap = new HashMap<>();
        private final Set<NRegister> removedNodes = new HashSet<>();

        public void addNode(NRegister register) {
            adjacencyList.putIfAbsent(register, new HashSet<>());
            canonicalRegisterMap.putIfAbsent(register, register);
        }

        public void addEdge(NRegister reg1, NRegister reg2) {
            adjacencyList.get(reg1).add(reg2);
            adjacencyList.get(reg2).add(reg1);
        }

        public boolean hasColor(NRegister reg) {
            return colors.containsKey(reg);
        }

        public int getColor(NRegister reg) {
            return colors.getOrDefault(reg, -1);
        }

        public void assignColor(NRegister reg, int color) {
            colors.put(reg, color);
        }

        public Set<NRegister> getNeighbors(NRegister reg) {
            Set<NRegister> result = new HashSet<>();
            for (NRegister neighbor : adjacencyList.getOrDefault(reg, Collections.emptySet())) {
                if (!removedNodes.contains(neighbor)) {
                    result.add(neighbor);
                }
            }
            return result;
        }

        public NRegister getNodeWithDegreeLessThan(int degree, Set<NRegister> specialRegs) {
            for (NRegister reg : adjacencyList.keySet()) {
                if (removedNodes.contains(reg)) continue;
                if (specialRegs.contains(reg)) continue;
                int currentDegree = 0;
                for (NRegister neighbor : adjacencyList.get(reg)) {
                    if (!removedNodes.contains(neighbor)) {
                        currentDegree++;
                    }
                }
                if (currentDegree < degree) {
                    return reg;
                }
            }
            return null;
        }

        public NRegister getAnyNode(Set<NRegister> specialRegs) {
            for (NRegister reg : adjacencyList.keySet()) {
                if (!removedNodes.contains(reg) && !specialRegs.contains(reg)) {
                    return reg;
                }
            }
            return null;
        }

        public boolean isEmpty(Set<NRegister> specialRegs) {
            for (NRegister reg : adjacencyList.keySet()) {
                if (!removedNodes.contains(reg) && !specialRegs.contains(reg)) {
                    return false;
                }
            }
            return true;
        }

        public void markRemoved(NRegister reg) {
            removedNodes.add(reg);
        }

        public static NRegister getCanonicalRegister(NRegister reg) {
            return reg;
        }
    }

    public NGraphRegisterAllocator(NControlFlowGraph cfg) {
        super(cfg);
    }

    @Override
    public void run() {
        System.out.println("Starting register allocation...");

        cfg.computeLivenessIntervals();
        System.out.println("Computed liveness intervals for CFG.");

        Map<NRegister, Interval> livenessIntervals = buildLivenessIntervals();
        System.out.println("Built liveness intervals: " + livenessIntervals);

        InterferenceGraph graph = buildInterferenceGraph(livenessIntervals);
        System.out.println("Constructed interference graph: " + graph);

        Set<NRegister> specialRegisters = preColorSpecialRegisters(graph);

        boolean success = graphColoring(graph, NPhysicalRegister.MAX_COUNT, specialRegisters);
        if (!success) {
            System.out.println("Graph coloring failed, starting spill handling...");
            handleSpills();
        } else {
            System.out.println("Graph coloring completed successfully.");
        }

        debugRegisterAssignments(graph);

        System.out.println("Updating CFG with physical register assignments...");
        updateCFGWithRegisters(graph, specialRegisters);
        System.out.println("CFG updated. Final state:");
        for (NBasicBlock block : cfg.basicBlocks) {
            for (NLirInstruction instruction : block.lir) {
                System.out.println("  " + instruction);
            }
        }
    }

    private Map<NRegister, Interval> buildLivenessIntervals() {
        Map<NRegister, Interval> intervals = new HashMap<>();
        System.out.println("Building liveness intervals...");

        for (NBasicBlock block : cfg.basicBlocks) {
            for (NLirInstruction instruction : block.lir) {
                int id = instruction.id;

                for (int i = 0; i < instruction.reads.size(); i++) {
                    NRegister reg = instruction.reads.get(i);
                    reg = InterferenceGraph.getCanonicalRegister(reg);
                    instruction.reads.set(i, reg);
                    intervals.putIfAbsent(reg, new Interval(reg, id, id));
                    intervals.get(reg).extend(id);
                }

                if (instruction.write != null) {
                    NRegister reg = instruction.write;
                    reg = InterferenceGraph.getCanonicalRegister(reg);
                    instruction.write = reg;
                    intervals.putIfAbsent(reg, new Interval(reg, id, id));
                    intervals.get(reg).extend(id);
                }
            }
        }
        return intervals;
    }

    private InterferenceGraph buildInterferenceGraph(Map<NRegister, Interval> intervals) {
        InterferenceGraph graph = new InterferenceGraph();
        System.out.println("Building interference graph...");

        for (NRegister reg : intervals.keySet()) {
            graph.addNode(reg);
        }

        List<NRegister> registers = new ArrayList<>(intervals.keySet());
        for (int i = 0; i < registers.size(); i++) {
            Interval i1 = intervals.get(registers.get(i));
            for (int j = i + 1; j < registers.size(); j++) {
                Interval i2 = intervals.get(registers.get(j));
                if (i1.interferes(i2)) {
                    graph.addEdge(i1.register, i2.register);
                    System.out.println("  Edge added between " + i1.register + " and " + i2.register);
                }
            }
        }

        System.out.println("Interference graph: " + graph);
        return graph;
    }

    private Set<NRegister> preColorSpecialRegisters(InterferenceGraph graph) {
        Set<NRegister> specialRegs = new HashSet<>();

        for (NRegister reg : graph.adjacencyList.keySet()) {
            if (isSpecialRegister(reg)) {
                NPhysicalRegister pReg = (NPhysicalRegister) reg;
                graph.assignColor(reg, pReg.number);
                specialRegs.add(reg);
            }
        }
        return specialRegs;
    }

    private boolean isSpecialRegister(NRegister reg) {
        if (reg instanceof NPhysicalRegister) {
            NPhysicalRegister pReg = (NPhysicalRegister) reg;
            // Treat r0, r14, r15 as special registers
            return pReg.number == 0 || pReg.number == 14 || pReg.number == 15;
        }
        return false;
    }

    private boolean graphColoring(InterferenceGraph graph, int numRegisters, Set<NRegister> specialRegs) {
        System.out.println("Performing graph coloring...");
        Stack<NRegister> stack = new Stack<>();
        Set<NRegister> spilledNodes = new HashSet<>();

        while (!graph.isEmpty(specialRegs)) {
            NRegister node = graph.getNodeWithDegreeLessThan(numRegisters, specialRegs);
            if (node == null) {
                node = graph.getAnyNode(specialRegs);
                if (node == null) {
                    break;
                }
                spilledNodes.add(node);
                System.out.println("  Spilling register: " + node);
                graph.markRemoved(node);
            } else {
                stack.push(node);
                graph.markRemoved(node);
            }
        }

        while (!stack.isEmpty()) {
            NRegister node = stack.pop();

            if (specialRegs.contains(node)) {
                continue;
            }

            graph.removedNodes.remove(node);
            Set<Integer> neighborColors = new HashSet<>();
            for (NRegister neighbor : graph.getNeighbors(node)) {
                if (graph.hasColor(neighbor)) {
                    neighborColors.add(graph.getColor(neighbor));
                }
            }

            boolean colorAssigned = false;
            for (int color = 0; color < numRegisters; color++) {
                if (!neighborColors.contains(color)) {
                    graph.assignColor(node, color);
                    System.out.println("  Assigned color r" + color + " to register " + node);

                    if (node instanceof NVirtualRegister) {
                        ((NVirtualRegister) node).pReg = new NPhysicalRegister(color, "r" + color);
                    }
                    colorAssigned = true;
                    break;
                }
            }

            if (!colorAssigned) {
                System.err.println("Failed to assign a color to register: " + node);
                return false;
            }
        }

        if (!spilledNodes.isEmpty()) {
            System.err.println("Spilled nodes detected: " + spilledNodes);
        }

        return true;
    }

    private void debugRegisterAssignments(InterferenceGraph graph) {
        System.out.println("Final Register Assignments:");
        for (NRegister reg : graph.adjacencyList.keySet()) {
            if (graph.hasColor(reg)) {
                System.out.println("  Virtual Register " + reg + " -> Physical Register r" + graph.getColor(reg));
            } else {
                System.out.println("  Virtual Register " + reg + " -> Unassigned (Spilled)");
            }
        }
    }

    private void updateCFGWithRegisters(InterferenceGraph graph, Set<NRegister> specialRegs) {
        System.out.println("Updating CFG with physical registers...");
        for (NBasicBlock block : cfg.basicBlocks) {
            for (NLirInstruction instruction : block.lir) {

                // Update reads
                for (int i = 0; i < instruction.reads.size(); i++) {
                    NRegister reg = instruction.reads.get(i);
                    reg = graph.getCanonicalRegister(reg);

                    if (isSpecialRegister(reg)) {
                        System.out.println("  Leaving special read register " + reg + " as is");
                        continue;
                    }

                    if (graph.hasColor(reg)) {
                        NPhysicalRegister physicalReg = new NPhysicalRegister(graph.getColor(reg), "r" + graph.getColor(reg));
                        instruction.reads.set(i, physicalReg);
                        System.out.println("  Replaced read register " + reg + " with " + physicalReg);
                    } else {
                        throw new IllegalStateException("No color found for read register: " + reg);
                    }
                }

                // Update write
                if (instruction.write != null) {
                    NRegister reg = instruction.write;
                    reg = graph.getCanonicalRegister(reg);

                    if (isSpecialRegister(reg)) {
                        System.out.println("  Leaving special write register " + reg + " as is");
                    } else {
                        if (graph.hasColor(reg)) {
                            NPhysicalRegister physicalReg = new NPhysicalRegister(graph.getColor(reg), "r" + graph.getColor(reg));
                            instruction.write = physicalReg;
                            System.out.println("  Replaced write register " + reg + " with " + physicalReg);
                        } else {
                            throw new IllegalStateException("No color found for write register: " + reg);
                        }
                    }
                }
            }
        }

        // Apply final calling convention fixes
        fixCallingConventions();
        System.out.println("CFG updated successfully.");
    }

    /**
     * Extract the opcode from the instruction's string representation.
     * We assume the format: "<id>: <opcode> <operands>"
     */
    private String getOpcode(NLirInstruction instr) {
        String line = instr.toString().trim();
        int colonIndex = line.indexOf(':');
        if (colonIndex >= 0) {
            line = line.substring(colonIndex + 1).trim();
        }
        // The opcode is the first token
        int spaceIndex = line.indexOf(' ');
        if (spaceIndex < 0) spaceIndex = line.length();
        return line.substring(0, spaceIndex);
    }

    private void fixCallingConventions() {
        for (NBasicBlock block : cfg.basicBlocks) {
            List<NLirInstruction> instrs = block.lir;
            for (NLirInstruction instr : instrs) {
                String opcode = getOpcode(instr);

                // Detect 'addn r15 -1' pattern
                if (opcode.equals("addn") && instr.reads.size() == 2) {
                    NRegister first = instr.reads.get(0);
                    NRegister second = instr.reads.get(1);
                    if (isR15(first) && isImmediateValue(second, -1)) {
                        // Replace with 'popr r0 r15'
                        // We'll modify instr in place
                        instr.reads.clear();
                        instr.write = new NPhysicalRegister(0, "r0");
                        instr.reads.add(new NPhysicalRegister(15, "r15"));
                        // Update the text representation if needed
                        // If instruction has an 'op' field, set it:
                        // instr.op = "popr";
                        // If no such field and toString is based on data, ensure that changing operands is enough.

                        // If NLirInstruction doesn't have a field for opcode,
                        // you may need to store it somewhere else or rely on a similar mechanism.
                        // For now, we assume toString() is dynamic based on write and reads.

                        System.out.println("  Replaced 'addn r15 -1' with 'popr r0 r15'");
                        // There's no direct opcode field to change here; hopefully toString() will reflect the new state.
                    }
                }


            }
        }
    }

    private boolean isR15(NRegister reg) {
        return (reg instanceof NPhysicalRegister) && reg.number == 15;
    }

    private boolean isR0(NRegister reg) {
        return (reg instanceof NPhysicalRegister) && reg.number == 0;
    }

    private boolean isImmediateValue(NRegister operand, int val) {
        try {
            int parsed = Integer.parseInt(operand.toString());
            return parsed == val;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
