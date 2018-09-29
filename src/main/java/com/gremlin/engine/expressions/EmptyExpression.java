package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;

public class EmptyExpression extends Expression
{
    
    public EmptyExpression() {
        
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
    
}