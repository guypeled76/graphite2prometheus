package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;


public class NumberExpression extends Expression
{
    private float value;

    public NumberExpression(float value) {
        this.value = value;
    }


    public NumberExpression(float value, float exponent) {
        this.value = value;
    }

    /**
     * Gest actual value from expression.
     * @return Expression value.
     */
    public float toValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}