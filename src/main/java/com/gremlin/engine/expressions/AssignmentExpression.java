package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;
import com.gremlin.engine.ProcessorException;

public class AssignmentExpression extends Expression
{
    private Expression target;
    private AssignmentKind kind;
    private Expression value;

    public AssignmentExpression(Expression target, AssignmentKind kind, Expression value) {
        this.target = target;
        this.kind = kind;
        this.value = value;    
    }

    @Override
    public Expression evaluate(Processor processor)  throws ProcessorException {
        return new EmptyExpression();
    }

    @Override
    public Expression execute(Processor processor)  throws ProcessorException {
        
        Expression assignValue = this.value;

        switch(this.kind) {
            case ASSIGN:
                assignValue = this.value;
                break;
            case PLUSASSIGN:
                assignValue =  new BinaryExpression(this.target, BinaryKind.ADDITION, this.value);
                break;
            case MINUSASSIGN:
                assignValue =  new BinaryExpression(this.target, BinaryKind.SUBTRACTION, this.value);
                break;
        }
        
        // Assign new target value
        this.target.assign(processor, assignValue.evaluate(processor));


        return new EmptyExpression();
    }

    @Override
    public String toString() {
        switch(this.kind)
        {
            case ASSIGN:
                return this.target.toString() + " = " + this.value.toString();
            case PLUSASSIGN:
                return this.target.toString() + " += " + this.value.toString();
            case MINUSASSIGN:
                return this.target.toString() + " -= " + this.value.toString();
        }

        return super.toString();
    }

}

