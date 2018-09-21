package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

public class BinaryExpression extends Expression
{
    private Expression target;
    private BinaryKind kind;
    private Expression value;

    public BinaryExpression(Expression target, BinaryKind kind, Expression value) {
        this.target = target;
        this.kind = kind;
        this.value = value;    
    }


    @Override
    public ExpressionResult Evaluate(Processor processor) {
        return null;
    }
}