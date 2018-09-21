package com.gremlin.engine;



public class Processor
{

	

	/**
	 * Executes an arithmethic expression or equation
	 * @param expressionOrEquation The arithmethic expression or equation to execute.
	 * @return The evaluation of the expression or null
	 */
	public Object Execute(String expressionOrEquation) {

		
		ExpressionBuilder expressionBuilder = new ExpressionBuilder();
		Expression expression = expressionBuilder.build(expressionOrEquation);
		if(expression != null) {
			return expression.Execute(this);
		}
		return expression;
	}


}