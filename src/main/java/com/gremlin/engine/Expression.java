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
	 * Evaluates the expression and returns an expression result.
	 * @param processor The current processor to evaluate the expression against.
	 * @return The expression result.
	 */
    public abstract ExpressionResult Evaluate(Processor processor);

	public static Expression build(String expressionOrEquation) {
        Lexer lexer = new ArithmeticLexer(CharStreams.fromString(expressionOrEquation));
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ArithmeticParser parser = new ArithmeticParser(tokenStream);
		ExpressionBuilder expressionBuilder = new ExpressionBuilder();
		return expressionBuilder.visitContent(parser.content());
	}

	
}