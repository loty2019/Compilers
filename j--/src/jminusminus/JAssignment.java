package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * This abstract base class is the AST node for an assignment operation.
 */
abstract class JAssignment extends JBinaryExpression {
    /**
     * Constructs an AST node for an assignment operation.
     *
     * @param line     line in which the assignment operation occurs in the source file.
     * @param operator the assignment operator.
     * @param lhs      the lhs operand.
     * @param rhs      the rhs operand.
     */
    public JAssignment(int line, String operator, JExpression lhs, JExpression rhs) {
        super(line, operator, lhs, rhs);
    }
}

/**
 * The AST node for an assignment (=) operation.
 */
class JAssignOp extends JAssignment {
    /**
     * Constructs the AST node for an assignment (=) operation.
     *
     * @param line line in which the assignment operation occurs in the source file.
     * @param lhs  lhs operand.
     * @param rhs  rhs operand.
     */
    public JAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "=", lhs, rhs);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        if (!(lhs instanceof JLhs)) {
            JAST.compilationUnit.reportSemanticError(line(), "illegal lhs for assignment");
        } else {
            lhs = ((JLhs) lhs).analyzeLhs(context);
            rhs = rhs.analyze(context);
            rhs.type().mustMatchExpected(line(), lhs.type());
            type = rhs.type();
            if (lhs instanceof JVariable) {
                Defn defn = ((JVariable) lhs).iDefn();
                if (defn != null) {
                    ((LocalVariableDefn) defn).initialize();
                }
            }
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        ((JLhs) lhs).codegenLoadLhsLvalue(output);
        rhs.codegen(output);
        if (!isStatementExpression) {
            ((JLhs) lhs).codegenDuplicateRvalue(output);
        }
        ((JLhs) lhs).codegenStore(output);
    }
}

/**
 * The AST node for a plus-assign (+=) operation.
 */
class JPlusAssignOp extends JAssignment {
    /**
     * Constructs the AST node for a plus-assign (+=) operation.
     *
     * @param line line in which the assignment operation occurs in the source file.
     * @param lhs  the lhs operand.
     * @param rhs  the rhs operand.
     */
    public JPlusAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "+=", lhs, rhs);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        if (!(lhs instanceof JLhs)) {
            return this;
        }
        lhs = ((JLhs) lhs).analyzeLhs(context);
        rhs = rhs.analyze(context);

        if (lhs.type() == Type.STRING) {
            rhs = (new JStringConcatenationOp(line, lhs, rhs)).analyze(context);
            type = Type.STRING;
        } else if (lhs.type() == Type.INT && rhs.type() == Type.INT) {
            type = Type.INT;
        } else if (lhs.type() == Type.LONG && rhs.type() == Type.LONG) {
            type = Type.LONG;
        } else if (lhs.type() == Type.DOUBLE && rhs.type() == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else {
            type = Type.INT;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        ((JLhs) lhs).codegenLoadLhsLvalue(output);
        if (lhs.type().equals(Type.STRING)) {
            rhs.codegen(output);
        } else {
            ((JLhs) lhs).codegenLoadLhsRvalue(output);
            rhs.codegen(output);
            if (type == Type.INT) {
                output.addNoArgInstruction(IADD);
            } else if (type == Type.LONG) {
                output.addNoArgInstruction(LADD);
            } else if (type == Type.DOUBLE) {
                output.addNoArgInstruction(DADD);
            }
        }
        if (!isStatementExpression) {
            ((JLhs) lhs).codegenDuplicateRvalue(output);
        }
        ((JLhs) lhs).codegenStore(output);
    }
}

/**
 * The AST node for a minus-assign (-=) operation.
 */
class JMinusAssignOp extends JAssignment {
    /**
     * Constructs the AST node for a minus-assign operation.
     *
     * @param line line in which the assignment operation occurs in the source file.
     * @param lhs  the lhs operand.
     * @param rhs  the rhs operand.
     */
    public JMinusAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "-=", lhs, rhs);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        if (!(lhs instanceof JLhs)) {
            return this;
        }
        lhs = ((JLhs) lhs).analyzeLhs(context);
        rhs = rhs.analyze(context);

        if (lhs.type() == Type.STRING) {
            rhs = (new JStringConcatenationOp(line, lhs, rhs)).analyze(context);
            type = Type.STRING;
        } else if (lhs.type() == Type.INT && rhs.type() == Type.INT) {
            type = Type.INT;
        } else if (lhs.type() == Type.LONG && rhs.type() == Type.LONG) {
            type = Type.LONG;
        } else if (lhs.type() == Type.DOUBLE && rhs.type() == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else {
            type = Type.INT;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        ((JLhs) lhs).codegenLoadLhsLvalue(output);
        ((JLhs) lhs).codegenLoadLhsRvalue(output);
        rhs.codegen(output);
        if (type == Type.INT) {
            output.addNoArgInstruction(ISUB);
        } else if (type == Type.LONG) {
            output.addNoArgInstruction(LSUB);
        } else if (type == Type.DOUBLE) {
            output.addNoArgInstruction(DSUB);
        }
        if (!isStatementExpression) {
            ((JLhs) lhs).codegenDuplicateRvalue(output);
        }
        ((JLhs) lhs).codegenStore(output);
    }
}

/**
 * The AST node for a star-assign (*=) operation.
 */
class JStarAssignOp extends JAssignment {
    /**
     * Constructs the AST node for a star-assign operation.
     *
     * @param line line in which the assignment operation occurs in the source file.
     * @param lhs  the lhs operand.
     * @param rhs  the rhs operand.
     */
    public JStarAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "*=", lhs, rhs);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        if (!(lhs instanceof JLhs)) {
            return this;
        }
        lhs = ((JLhs) lhs).analyzeLhs(context);
        rhs = rhs.analyze(context);

        if (lhs.type() == Type.STRING) {
            rhs = (new JStringConcatenationOp(line, lhs, rhs)).analyze(context);
            type = Type.STRING;
        } else if (lhs.type() == Type.INT && rhs.type() == Type.INT) {
            type = Type.INT;
        } else if (lhs.type() == Type.LONG && rhs.type() == Type.LONG) {
            type = Type.LONG;
        } else if (lhs.type() == Type.DOUBLE && rhs.type() == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else {
            type = Type.INT;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        ((JLhs) lhs).codegenLoadLhsLvalue(output);
        ((JLhs) lhs).codegenLoadLhsRvalue(output);
        rhs.codegen(output);
        if (type == Type.INT) {
            output.addNoArgInstruction(IMUL);
        } else if (type == Type.LONG) {
            output.addNoArgInstruction(LMUL);
        } else if (type == Type.DOUBLE) {
            output.addNoArgInstruction(DMUL);
        }
        if (!isStatementExpression) {
            ((JLhs) lhs).codegenDuplicateRvalue(output);
        }
        ((JLhs) lhs).codegenStore(output);
    }
}

/**
 * The AST node for a div-assign (/=) operation.
 */
class JDivAssignOp extends JAssignment {
    /**
     * Constructs the AST node for a div-assign operation.
     *
     * @param line line in which the assignment operation occurs in the source file.
     * @param lhs  the lhs operand.
     * @param rhs  the rhs operand.
     */
    public JDivAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "/=", lhs, rhs);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        if (!(lhs instanceof JLhs)) {
            return this;
        }
        lhs = ((JLhs) lhs).analyzeLhs(context);
        rhs = rhs.analyze(context);

        if (lhs.type() == Type.STRING) {
            rhs = (new JStringConcatenationOp(line, lhs, rhs)).analyze(context);
            type = Type.STRING;
        } else if (lhs.type() == Type.INT && rhs.type() == Type.INT) {
            type = Type.INT;
        } else if (lhs.type() == Type.LONG && rhs.type() == Type.LONG) {
            type = Type.LONG;
        } else if (lhs.type() == Type.DOUBLE && rhs.type() == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else {
            type = Type.INT;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        ((JLhs) lhs).codegenLoadLhsLvalue(output);
        ((JLhs) lhs).codegenLoadLhsRvalue(output);
        rhs.codegen(output);
        if (type == Type.INT) {
            output.addNoArgInstruction(IDIV);
        } else if (type == Type.LONG) {
            output.addNoArgInstruction(LDIV);
        } else if (type == Type.DOUBLE) {
            output.addNoArgInstruction(DDIV);
        }
        if (!isStatementExpression) {
            ((JLhs) lhs).codegenDuplicateRvalue(output);
        }
        ((JLhs) lhs).codegenStore(output);
    }
}

/**
 * The AST node for a rem-assign (%=) operation.
 */
class JRemAssignOp extends JAssignment {
    /**
     * Constructs the AST node for a rem-assign operation.
     *
     * @param line line in which the assignment operation occurs in the source file.
     * @param lhs  the lhs operand.
     * @param rhs  the rhs operand.
     */
    public JRemAssignOp(int line, JExpression lhs, JExpression rhs) {
        super(line, "%=", lhs, rhs);
    }

    /**
     * {@inheritDoc}
     */
    public JExpression analyze(Context context) {
        if (!(lhs instanceof JLhs)) {
            return this;
        }
        lhs = ((JLhs) lhs).analyzeLhs(context);
        rhs = rhs.analyze(context);

        if (lhs.type() == Type.STRING) {
            rhs = (new JStringConcatenationOp(line, lhs, rhs)).analyze(context);
            type = Type.STRING;
        } else if (lhs.type() == Type.INT && rhs.type() == Type.INT) {
            type = Type.INT;
        } else if (lhs.type() == Type.LONG && rhs.type() == Type.LONG) {
            type = Type.LONG;
        } else if (lhs.type() == Type.DOUBLE && rhs.type() == Type.DOUBLE) {
            type = Type.DOUBLE;
        } else {
            type = Type.INT;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public void codegen(CLEmitter output) {
        ((JLhs) lhs).codegenLoadLhsLvalue(output);
        ((JLhs) lhs).codegenLoadLhsRvalue(output);
        rhs.codegen(output);
        if (type == Type.INT) {
            output.addNoArgInstruction(IREM);
        } else if (type == Type.LONG) {
            output.addNoArgInstruction(LREM);
        } else if (type == Type.DOUBLE) {
            output.addNoArgInstruction(DREM);
        }
        if (!isStatementExpression) {
            ((JLhs) lhs).codegenDuplicateRvalue(output);
        }
        ((JLhs) lhs).codegenStore(output);
    }
}
