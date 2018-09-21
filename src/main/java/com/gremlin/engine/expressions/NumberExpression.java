package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

public class NumberExpression extends Expression
{
    private float value;

    public NumberExpression(float value) {
        this.value = value;
    }


    public NumberExpression(float value, float exponent) {
        this.value = value;
    }

    @Override
    public ExpressionResult Evaluate(Processor processor) {
        return ExpressionResult.forValue(this.value);
    }
}