package com.gremlin.engine.expressions;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;
import com.gremlin.engine.ProcessorException;

/**
 * Provides support for functions
 */
public class FunctionExpression extends Expression
{
    /**
     * The function arguments
     */
    private ArrayList<Expression> arguments  = null;

    /**
     * The function name
     */
    private String name = null;

    /**
     * Create a new expression
     * @param name The function name
     * @param arguments The function arguments
     */
    public FunctionExpression(String name, ArrayList<Expression> arguments) {
        this.arguments = arguments;
        this.name = name;
    }

    @Override
    public boolean isExit() {
        return new String("exit").equals(this.name);
    }

    @Override
    public boolean isDebug() {
        return new String("debug").equals(this.name);
    }
 
    @Override
    public Expression evaluate(Processor processor) throws ProcessorException {
        
        // If is not special methods
        if(!isExit() && !isDebug())
        {
            // Get method from name and parameters
            Method method = null;
            
            // Try to get method
            try {
                method = Math.class.getDeclaredMethod(this.name, this.getArgumentTypes());
            } catch(Exception exception) {
                throw new ProcessorException(String.format("Failed to resolve '%s' method.", this.name),exception);
            }
            
            // Get evaluated arguments
            ArrayList<Expression> evaluatedArguments = getEvaluatedArguments(processor);

            // If we can evaluate all arguments to numbers
            if(isNumericArguments(evaluatedArguments)) {

                // Get values
                double[] values = getNumericArguments(evaluatedArguments);

                try {
                    // Invoke method
                    switch(values.length){
                        case 1:
                            return new NumberExpression((double)method.invoke(null,values[0]));
                        case 2:
                            return new NumberExpression((double)method.invoke(null,values[0], values[1]));
                        default:
                            return new NumberExpression((double)method.invoke(null,new Object[]{}));
                    }
                } catch(Exception exception) {
                    throw new ProcessorException(String.format("Failed to invoke '%s' method.", this.name),exception);
                }
                
            } else {
                return new FunctionExpression(this.name, evaluatedArguments);
            }
        }
        else{
            return this;
        }
 
    }

    /**
     * Gets numeric argument values.
     * @param arguments The arguments
     * @return Array of numbers.
     */
    private double[] getNumericArguments(ArrayList<Expression> arguments) {
        double[] values = new double[this.arguments.size()];
        for(int i=0;i<values.length; i++){
            values[i] = ((NumberExpression)arguments.get(i)).toValue();
        }
        return values;
    }

    /**
     * Gets argument types
     * @return The argument types
     */
    private Class<?>[] getArgumentTypes() {
        Class<?>[] types = new Class<?>[this.arguments.size()];
        for(int i=0;i<types.length; i++){
            types[i] = double.class;
        }
        return types;
    }

    /**
     * Checks if all arguments are numeric
     * @param arguments The arguments to check
     * @return True if all arguments are numeric
     */
    private boolean isNumericArguments(ArrayList<Expression> arguments) {
        for(Expression argument : this.arguments) {
            if(!(argument instanceof NumberExpression)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gest evaluated arguments
     * @param processor The related processor
     * @return The list of evaluated arguments
     */
    private ArrayList<Expression> getEvaluatedArguments(Processor processor) throws ProcessorException {
        ArrayList<Expression> evaluatedArguments = new ArrayList<Expression>();
        for(Expression argument : this.arguments) {
            evaluatedArguments.add(argument.evaluate(processor));
        }
        return evaluatedArguments;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        builder.append("(");
        if(this.arguments != null) {
            boolean first = true;
            for(Expression argument : this.arguments) {
                if(!first) builder.append(", ");
                builder.append(argument.toString());
                first = false;
            }
        }
        builder.append(")");
        return builder.toString();
    }
    
}