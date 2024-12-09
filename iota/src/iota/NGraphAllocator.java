package iota;

import java.util.*;

/**
 * A register allocator that uses the graph coloring algorithm to allocate physical registers to virtual registers.
 */
class NGraphRegisterAllocator extends NRegisterAllocator {

    // Placeholder for the Interval class
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

    // Placeholder for the InterferenceGraph class
    private static class InterferenceGraph {
        private final Map<NRegister, Set<NRegister>> adjacencyList = new HashMap<>();
        private final Map<NRegister, Integer> colors = new HashMap<>();
        private final Map<NRegister, NRegister> canonicalRegisterMap = new HashMap<>();

        public void addNode(NRegister register) {
            adjacencyList.putIfAbsent(register, new HashSet<>());
            canonicalRegisterMap.putIfAbsent(register, register); // Ensure every register has a canonical mapping
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
            return adjacencyList.getOrDefault(reg, new HashSet<>());
        }

        public NRegister getNodeWithDegreeLessThan(int degree) {
            for (NRegister reg : adjacencyList.keySet()) {
                if (adjacencyList.get(reg).size() < degree) {
                    return reg;
                }
            }
            return null;
        }

        public NRegister getAnyNode() {
            return adjacencyList.keySet().stream().findFirst().orElse(null);
        }

        public void removeNode(NRegister reg) {
            adjacencyList.remove(reg);
            for (Set<NRegister> neighbors : adjacencyList.values()) {
                neighbors.remove(reg);
            }
        }

        public boolean isEmpty() {
            return adjacencyList.isEmpty();
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

        // Step 1: Ensure liveness intervals are computed
        cfg.computeLivenessIntervals();
        System.out.println("Computed liveness intervals for CFG.");

        // Step 2: Build liveness intervals
        Map<NRegister, Interval> livenessIntervals = buildLivenessIntervals();
        System.out.println("Built liveness intervals: " + livenessIntervals);

        // Step 3: Construct the interference graph
        InterferenceGraph graph = buildInterferenceGraph(livenessIntervals);
        System.out.println("Constructed interference graph: " + graph);

        // Step 4: Perform graph coloring
        boolean success = graphColoring(graph, NPhysicalRegister.MAX_COUNT);
        if (!success) {
            System.out.println("Graph coloring failed, starting spill handling...");
            handleSpills();
        } else {
            System.out.println("Graph coloring completed successfully.");
        }

        // Step 5: Update CFG with register assignments
        System.out.println("Updating CFG with physical register assignments...");
        updateCFGWithRegisters(graph);
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

        for (Interval i1 : intervals.values()) {
            for (Interval i2 : intervals.values()) {
                if (!i1.equals(i2) && i1.interferes(i2)) {
                    graph.addEdge(i1.register, i2.register);
                }
            }
        }

        return graph;
    }

    private boolean graphColoring(InterferenceGraph graph, int numRegisters) {
        System.out.println("Performing graph coloring...");
        Stack<NRegister> stack = new Stack<>();
        Set<NRegister> spilledNodes = new HashSet<>();

        // Build the stack by removing nodes with degree < numRegisters
        while (!graph.isEmpty()) {
            NRegister node = graph.getNodeWithDegreeLessThan(numRegisters);
            if (node == null) {
                // If all nodes have degree >= numRegisters, spill one
                node = graph.getAnyNode();
                spilledNodes.add(node);
                System.out.println("  Spilling register: " + node);
            } else {
                stack.push(node);
                graph.removeNode(node);
            }
        }

        // Assign colors while popping the stack
        while (!stack.isEmpty()) {
            NRegister node = stack.pop();
            Set<Integer> neighborColors = new HashSet<>();

            // Collect colors used by neighbors
            for (NRegister neighbor : graph.getNeighbors(node)) {
                if (graph.hasColor(neighbor)) {
                    neighborColors.add(graph.getColor(neighbor));
                }
            }

            // Assign the first available color
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
            // Optional: Implement spill handling logic here
        }

        return true;
    }


    private void updateCFGWithRegisters(InterferenceGraph graph) {
        System.out.println("Updating CFG with physical registers...");
        for (NBasicBlock block : cfg.basicBlocks) {
            for (NLirInstruction instruction : block.lir) {
                // Update reads
                for (int i = 0; i < instruction.reads.size(); i++) {
                    NRegister reg = instruction.reads.get(i);
                    reg = graph.getCanonicalRegister(reg); // Canonicalize the register
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
                    reg = graph.getCanonicalRegister(reg); // Canonicalize the register
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
        System.out.println("CFG updated successfully.");
    }

}
