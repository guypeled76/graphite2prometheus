package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;
import com.gremlin.engine.ProcessorException;

public class ParenthesesExpression extends Expression
{
    private Expression expression;

    public ParenthesesExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Expression evaluate(Processor processor) throws ProcessorException {
        return this.expression.evaluate(processor);
    }

    @Override
    public Expression execute(Processor processor) throws ProcessorException {
        return this.expression.execute(processor);
    }

    @Override
    public void assign(Processor processor, Expression value) throws ProcessorException {
        this.expression.assign(processor, value);
    }

    @Override
    public String toString() {
        return "(" + this.expression.toString() + ")";
    }
}