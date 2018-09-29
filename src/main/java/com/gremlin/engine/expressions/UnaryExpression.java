package com.gremlin.engine.expressions;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;
import com.gremlin.engine.ProcessorException;

public class UnaryExpression extends Expression
{
    private Expression expression;

    private UnaryKind kind;

    public UnaryExpression(Expression expression, UnaryKind kind) {
        this.expression = expression;
        this.kind = kind;
    }

    @Override
    public Expression evaluate(Processor processor) throws ProcessorException {
        
        // If is the minus unary operator
        if(this.kind == UnaryKind.MINUS)
        {
            // Evaluate the expression
            Expression evaluatedExpression = this.expression.evaluate(processor);

            // If expressions was reduced a number expressions
            if(evaluatedExpression instanceof NumberExpression) {

                // Get number from expression
                Double expressionValue = ((NumberExpression)evaluatedExpression).toValue();

                // Return the negative value
                return new NumberExpression(expressionValue * -1);
            }

            // Return self
            return this;
        }
        else
        {
            // If expression is a variable
            if(this.expression instanceof VariableExpression) {

                // Get variable
                VariableExpression variable = ((VariableExpression)this.expression);

                Expression value = this;

                // Evaluate operation based on kind
                switch(this.kind)
                {
                    case POSTMINUSMINUS:
                        value = variable.evaluate(processor);
                        variable.decrement(processor);
                        break;
                    case PREMINUSMINUS:
                        variable.decrement(processor);
                        value = variable.evaluate(processor);
                        break;
                    case POSTPLUSPLUS:
                        value = variable.evaluate(processor);
                        variable.increment(processor);
                        break;
                    case PREPLUSPLUS:
                        variable.increment(processor);
                        value = variable.evaluate(processor);
                        break;
                    case MINUS:
                        break;
                }


                return value;
            }
        }

        return this;
        
        
    }

    @Override
    public String toString() {
        switch(this.kind)
        {
            case MINUS:
                return "-" + this.expression.toString();
            case POSTMINUSMINUS:
                return this.expression.toString() + "--";
            case PREMINUSMINUS:
                return "--" + this.expression.toString();
            case POSTPLUSPLUS:
                return this.expression.toString() + "++";
            case PREPLUSPLUS:
                return "++" + this.expression.toString();
        }

        return super.toString();
    }

}