package com.gremlin.engine;

import com.gremlin.apps.ArithmeticLexer;
import com.gremlin.apps.ArithmeticParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

public class Expression
{
    public Object Execute(Processor processor) {
        return null;
    }

	public static Expression build(String expressionOrEquation) {
        Lexer lexer = new ArithmeticLexer(CharStreams.fromString(expressionOrEquation));
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ArithmeticParser parser = new ArithmeticParser(tokenStream);
		ExpressionBuilder expressionBuilder = new ExpressionBuilder();
		return expressionBuilder.visitContent(parser.content());
	}
}