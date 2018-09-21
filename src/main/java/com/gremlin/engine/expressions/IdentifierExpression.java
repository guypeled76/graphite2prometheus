package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

public class IdentifierExpression extends Expression
{
    private String identifier;

    public IdentifierExpression(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public ExpressionResult Evaluate(Processor processor) {
        Object value = processor.getIdentifierValue(this.identifier);
        return ExpressionResult.forIdentifier(this.identifier, value);
    }
}