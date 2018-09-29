package com.gremlin.engine;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Provides support for turning parsing errors to exceptions
 */
public class ExpressionBuilderErrorListner extends BaseErrorListener {

    /**
     * Holds the first exception
     */
    private ProcessorException exception = null;

    /**
     * Handle syntax error and throw exception
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        if(this.exception == null) {
            exception = new ProcessorException("col:" + charPositionInLine + " " + msg, e);
        }
    }

    /**
     * Throws exception if there is one to throw
     * @throws ProcessorException
     */
    public void throwExceptionIfNeeded() throws ProcessorException {
        if(this.exception!= null) throw this.exception;
    }
}