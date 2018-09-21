package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

class PrimitiveExpression extends Expression
{
    private Object value;

    public PrimitiveExpression(Object value) {
        this.value = value;
    }

    @Override
    public ExpressionResult Evaluate(Processor processor) {
        return ExpressionResult.forValue(this.value);
    }
}