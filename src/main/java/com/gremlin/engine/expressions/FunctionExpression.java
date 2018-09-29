package com.gremlin.engine.expressions;

import java.util.ArrayList;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;

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
    public Expression evaluate(Processor processor) {
        return super.evaluate(processor);
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