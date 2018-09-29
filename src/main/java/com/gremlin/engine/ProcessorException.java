package com.gremlin.engine;


/**
 * Provides support for processor exception.
 */
public class ProcessorException extends Exception
{

    private static final long serialVersionUID = 1L;

    
    public ProcessorException() {
        super();
    }

 
    public ProcessorException(String message) {
        super(message);
    }


    public ProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessorException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

}
