package jminusminus;

import static jminusminus.CLConstants.GOTO;

/**
 * The AST node for a conditional expression.
 */
class JConditionalExpression extends JExpression {
    // Test expression.
    private JExpression condition;

    // Then part.
    private JExpression thenPart;

    // Else part.
    private JExpression elsePart;

    /**
     * Constructs an AST node for a conditional expression.
     *
     * @param line      line in which the conditional expression occurs in the source file.
     * @param condition test expression.
     * @param thenPart  then part.
     * @param elsePart  else part.
     */
    public JConditionalExpression(int line, JExpression condition, JExpression thenPart, JExpression elsePart) {
        super(line);
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        condition = condition.analyze(context);
        thenPart = thenPart.analyze(context);
        elsePart = elsePart.analyze(context);
        condition.type().mustMatchExpected(line, Type.BOOLEAN);
        thenPart.type().mustMatchExpected(line, elsePart.type());
        type = thenPart.type();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        String elseLabel = output.createLabel();
        String end = output.createLabel();

        // Condition
        condition.codegen(output, elseLabel, false);

        // then
        // had to import "import static jminusminus.CLConstants.GOTO;"
        thenPart.codegen(output);
        output.addBranchInstruction(GOTO, end);

        // else
        output.addLabel(elseLabel);
        elsePart.codegen(output);

        output.addLabel(end);
    }

    /**
     * {@inheritDoc}
     */
    public void toJSON(JSONElement json) {
        JSONElement e = new JSONElement();
        json.addChild("JConditionalExpression:" + line, e);
        JSONElement e1 = new JSONElement();
        e.addChild("Condition", e1);
        condition.toJSON(e1);
        JSONElement e2 = new JSONElement();
        e.addChild("ThenPart", e2);
        thenPart.toJSON(e2);
        JSONElement e3 = new JSONElement();
        e.addChild("ElsePart", e3);
        elsePart.toJSON(e3);
    }
}
