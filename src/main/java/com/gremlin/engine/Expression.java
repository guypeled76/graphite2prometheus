package com.gremlin.engine;



import com.gremlin.apps.ArithmeticLexer;
import com.gremlin.apps.ArithmeticParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

public abstract class Expression
{
	/**
	 * Builds an expression from expression text
	 * @param expression The text expression
	 * @return
	 */
	public static Expression build(String expression) {
        Lexer lexer = new ArithmeticLexer(CharStreams.fromString(expression));
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ArithmeticParser parser = new ArithmeticParser(tokenStream);
		ExpressionBuilder expressionBuilder = new ExpressionBuilder();
		return expressionBuilder.visitContent(parser.content());
	}

	/**
	 * Evaluates the expression
	 * @param processor The related processor.
	 * @return The evaluated value of the expression.
	 */
	public Expression evaluate(Processor processor) {
		return this;
	} 

	/**
	 * Executes an expression and preforms it's state changing operations.
	 * @param processor The related processor.
	 * @return The execution result if is a value
	 */
	public Expression execute(Processor processor) {
		return this.evaluate(processor);
	}

	/**
	 * Assign value to expressions that allow assignments.
	 * @param processor The related processor.
	 * @param value The value to assign.
	 */
	public void assign(Processor processor, Expression value) {

	}
}