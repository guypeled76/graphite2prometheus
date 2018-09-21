package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

public class ParenthesesExpression extends Expression
{
    private Expression expression;

    public ParenthesesExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ExpressionResult Evaluate(Processor processor) {
        return this.expression.Evaluate(processor);
    }
}