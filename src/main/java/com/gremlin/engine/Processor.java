package com.gremlin.engine;


import java.util.HashMap;


/**
 * Provides support for processing arithmetics expressions.
 */
public class Processor
{

	/**
	 * Holds the processor state
	 */
	private HashMap<String, Object> state = new HashMap<String, Object>();


	/**
	 * Evaluate an arithmethic expression or equation
	 * @param expressionOrEquation The arithmethic expression or equation to evaluate.
	 * @return The evaluation of the expression or null
	 */
	public ExpressionResult evaluate(String expressionOrEquation) {

		
		Expression expression = Expression.build(expressionOrEquation);
		if(expression != null) {
			return expression.Evaluate(this);
		}
		return null;
	}

	/**
	 * Gets identifier state value
	 * @param identifier The identifier to get it's state.
	 * @return The identifier state.
	 */
	public Object getIdentifierValue(String identifier) {
		return this.state.get(identifier);
	}

	public void setIdentifierValue(String identifier, Object value) {
		this.state.put(identifier, value);
	}


}