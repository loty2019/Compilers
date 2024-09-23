package jminusminus;

import static jminusminus.CLConstants.GOTO;

/**
 * The AST node for a do-statement.
 */
class JDoStatement extends JStatement {
    // Body.
    private JStatement body;

    // Test expression.
    private JExpression condition;

    /**
     * Constructs an AST node for a do-statement.
     *
     * @param line      line in which the do-statement occurs in the source file.
     * @param body      the body.
     * @param condition test expression.
     */
    public JDoStatement(int line, JStatement body, JExpression condition) {
        super(line);
        this.body = body;
        this.condition = condition;
    }

    /**
     * {@inheritDoc}
     */
    public JStatement analyze(Context context) {
        // Analyze body and condition
        body = (JStatement) body.analyze(context);
        condition = condition.analyze(context);
        condition.type().mustMatchExpected(line, Type.BOOLEAN);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        // Labels for the start and end of the loop
        String start = output.createLabel();
        String end = output.createLabel();

        // Beginning of the loop
        output.addLabel(start);
        body.codegen(output);
        condition.codegen(output, end, false);  // Jump to endLabel if condition is false

        // Condition is true so jump back to the start of the loop
        // I had to import "import static jminusminus.CLConstants.GOTO;"
        output.addBranchInstruction(GOTO, start);

        // End of the loop
        output.addLabel(end);
    }

    /**
     * {@inheritDoc}
     */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JDoStatement:" + line, e);
        JSONElement e1 = new JSONElement();
        e.addChild("Body", e1);
        body.toJSON(e1);
        JSONElement e2 = new JSONElement();
        e.addChild("Condition", e2);
        condition.toJSON(e2);
    }
}
