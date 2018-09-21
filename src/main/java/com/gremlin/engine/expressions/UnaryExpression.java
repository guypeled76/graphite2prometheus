package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

public class UnaryExpression extends Expression
{
    private Expression expression;

    private UnaryKind kind;

    public UnaryExpression(Expression expression, UnaryKind kind) {
        this.expression = expression;
        this.kind = kind;
    }

    @Override
    public ExpressionResult Evaluate(Processor processor) {
        return null;
    }
}