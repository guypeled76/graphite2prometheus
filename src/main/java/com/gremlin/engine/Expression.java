package com.gremlin.engine;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

public abstract class Expression
{
	
	/**
	 * Builds an expression from expression text
	 * 
	 * @param expression The text expression
	 * @return
	 * @throws ProcessorException
	 */
	public static Expression build(String expression) throws ProcessorException {
		
		Expression builtExpression = null;

		// Error listener that handles lexer and parser errors
		ExpressionBuilderErrorListner errorListner = new ExpressionBuilderErrorListner();
		

		// Create lexer
		Lexer lexer = new ArithmeticLexer(CharStreams.fromString(expression));
		lexer.removeErrorListeners();
		lexer.addErrorListener(errorListner);
	
		// Create parser
		ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(lexer));
		parser.removeErrorListeners();
		parser.addErrorListener(errorListner);

		// Try to build expression
		ExpressionBuilder expressionBuilder = new ExpressionBuilder();
		builtExpression = expressionBuilder.visitContent(parser.content());

		// Throw exception if needed
		errorListner.throwExceptionIfNeeded();

		return builtExpression;
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
	public Expression evaluate(Processor processor) throws ProcessorException {
		return this;
	} 

	/**
	 * Executes an expression and preforms it's state changing operations.
	 * @param processor The related processor.
	 * @return The execution result if is a value
	 */
	public Expression execute(Processor processor) throws ProcessorException {
		return this.evaluate(processor);
	}

	/**
	 * Assign value to expressions that allow assignments.
	 * @param processor The related processor.
	 * @param value The value to assign.
	 */
	public void assign(Processor processor, Expression value) throws ProcessorException {

	}

	
}