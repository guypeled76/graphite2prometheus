package com.gremlin.engine;

import com.gremlin.engine.expressions.EmptyExpression;

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
	 * Check is an empty expression
	 * @return True if is an empty expression.
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Check is a debug expression
	 * @return True if is a debug expression.
	 */
	public boolean isDebug() {
		return false;
	}

	/**
	 * Check is an exit expression
	 * @return True if is an empty expression.
	 */
	public boolean isExit() {
		return false;
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