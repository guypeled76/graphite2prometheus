package com.gremlin.engine;


import java.util.HashMap;
import java.util.Map;

import com.gremlin.engine.expressions.*;


/**
 * Provides support for processing arithmetics expressions.
 */
public class Processor
{

	/**
	 * Holds the processor state
	 */
	private HashMap<String, Expression> state = new HashMap<String, Expression>();


	/**
	 * Evaluate an arithmethic expression
	 * @param expressionOrEquation The arithmethic expression to evaluate.
	 * @return The evaluation of the expression or null
	 */
	public Expression evaluate(String expressionOrEquation) {

		
		Expression expression = Expression.build(expressionOrEquation);
		if(expression != null) {
			return expression.evaluate(this);
		}
		return null;
	}

	/**
	 * Execute an arithmethic expression
	 * @param expressionOrEquation The arithmethic expression to execute.
	 * @return The evaluation of the expression
	 */
	public Expression execute(String expressionOrEquation) {

		
		Expression expression = Expression.build(expressionOrEquation);
		if(expression != null) {
			return expression.execute(this);
		}
		return null;
	}

	/** 
	 * Gets the identifier expression value
	 * @param identifier The identifier to get it's value.
	 * @return The identifier value.
	 */
	public Expression evaluateVariable(String identifier) {
		Expression value = this.state.get(identifier);
		if(value == null)
		{
			value = new NumberExpression(0);
		}
		return value;
	}

	/**
	 * Checks if a variable is specific value
	 * @param identifier The variable identifier
	 * @param value The value to check
	 * @return True if variable value is same as value
	 */
	public boolean checkVariable(String identifier, float value)
	{
		Expression expression = this.state.get(identifier);
		if(expression instanceof NumberExpression)
		{
			return ((NumberExpression)expression).toValue() == value;
		}

		return false;
	}

	/**
	 * Set the identifier expresion value
	 * @param identifier The identifier
	 * @param value The identifier expresion value
	 */
	public void assignVariable(String identifier, Expression value) {
		this.state.put(identifier, value);
	}

	/**
	 * Returns a debug string of the processor state
	 * @return A debug string of the processor state
	 */
	public String debug() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		boolean isFirst = true;
		for(Map.Entry<String, Expression> entry : this.state.entrySet()) {
			if(!isFirst) builder.append(",");
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(entry.getValue());
			isFirst = false;
		}
		builder.append(")");
		return builder.toString();
	}


}