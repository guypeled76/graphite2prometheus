package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;


public class NumberExpression extends Expression
{
    private double value;

    public NumberExpression(double value) {
        this.value = value;
    }


    public NumberExpression(double value, double exponent) {
        this.value = value;
    }

    /**
     * Gest actual value from expression.
     * @return Expression value.
     */
    public double toValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}