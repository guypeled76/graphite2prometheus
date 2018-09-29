package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;
import com.gremlin.engine.ProcessorException;

public class BinaryExpression extends Expression
{
    private Expression left;
    private BinaryKind kind;
    private Expression right;

    public BinaryExpression(Expression left, BinaryKind kind, Expression right) {
        this.left = left;
        this.kind = kind;
        this.right = right;    
    }

    @Override
    public Expression evaluate(Processor processor)  throws ProcessorException {
        
        // Evaluate both sides of the binary expression
        Expression evaluatedLeft = this.left.evaluate(processor);
        Expression evaluatedRight = this.right.evaluate(processor);

        // If expressions was reduced o number expressions
        if(evaluatedLeft instanceof NumberExpression && evaluatedRight instanceof NumberExpression) {

            double leftValue = ((NumberExpression)evaluatedLeft).toValue();
            double rightValue = ((NumberExpression)evaluatedRight).toValue();

            // Evaluate operation based on kind
            switch(this.kind)
            {
                case SUBTRACTION:
                    return new NumberExpression(leftValue - rightValue);
                case ADDITION:
                    return new NumberExpression(leftValue + rightValue);
                case MULTIPLICATION:
                    return new NumberExpression(leftValue * rightValue);
                case DEVISION:
                    return new NumberExpression(leftValue / rightValue);
                case POWER:
                    return new NumberExpression(Math.pow(leftValue, rightValue));
                case MODULO:
                    return new NumberExpression(leftValue % rightValue);
            }
        }
        
        return new BinaryExpression(evaluatedLeft, this.kind, evaluatedRight);
    }


    @Override
    public String toString() {

        switch(this.kind)
        {
            case SUBTRACTION:
                return this.left.toString() + " - " + this.right.toString();
            case ADDITION:
                return this.left.toString() + " + " + this.right.toString();
            case MULTIPLICATION:
                return this.left.toString() + " * " + this.right.toString();
            case DEVISION:
                return this.left.toString() + " / " + this.right.toString();
            case POWER:
                return this.left.toString() + " ^ " + this.right.toString();
            case MODULO:
                return this.left.toString() + " % " + this.right.toString();
        }

        return super.toString();
    }
}