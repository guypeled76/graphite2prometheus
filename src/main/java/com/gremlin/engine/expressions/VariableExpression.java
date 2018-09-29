package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;


public class VariableExpression extends Expression
{
    private String identifier;


    public VariableExpression(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public Expression evaluate(Processor processor) {
        return processor.evaluateVariable(this.identifier);
    }

    @Override
    public void assign(Processor processor, Expression value) {
        processor.assignVariable(this.identifier, value);
    }

    /**
     * Decrement the variable value.
     * @param processor The current related processor
     */
	public void decrement(Processor processor) throws Exception {
        Expression value = processor.evaluateVariable(this.identifier);
        value = new BinaryExpression(value, BinaryKind.SUBTRACTION, new NumberExpression(1));
        value = value.evaluate(processor);
        processor.assignVariable(this.identifier, value);
	}

    /**
     * Increment the variable value.
     * @param processor The current related processor
     */
	public void increment(Processor processor) throws Exception {
        Expression value = processor.evaluateVariable(this.identifier);
        value = new BinaryExpression(value, BinaryKind.ADDITION, new NumberExpression(1));
        value = value.evaluate(processor);
        processor.assignVariable(this.identifier, value);
    }
    
    @Override
    public String toString() {
        return this.identifier;
    }


}