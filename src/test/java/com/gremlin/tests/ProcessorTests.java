package com.gremlin.tests;

import static org.junit.Assert.assertTrue;
import com.gremlin.engine.*;
import org.junit.Test;

public class ProcessorTests
{
    private Processor processor = new Processor();

    @Test()
    public void Test1()
    {
        //ExpressionResult a = processor.evaluate("a = 2 * (2 + 1)");
        ExpressionResult b = processor.evaluate("b = a++ + 2");

        //assertTrue("Expected a to be 2.", processor.Execute("a") == 2);
    }
}