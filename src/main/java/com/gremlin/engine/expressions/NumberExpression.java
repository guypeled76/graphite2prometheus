package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;


public class NumberExpression extends Expression
{
    private double value;

    public NumberExpression(double value) {
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
        long longValue = (long)this.value;
        if(longValue == this.value) {
            return String.valueOf(longValue);
        }
        else {
            return String.valueOf(this.value);
        }
        
    }
}