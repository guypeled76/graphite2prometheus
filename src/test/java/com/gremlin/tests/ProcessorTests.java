package com.gremlin.tests;

import static org.junit.Assert.assertTrue;
import com.gremlin.engine.*;
import org.junit.Test;

public class ProcessorTests
{
    
    @Test()
    public void Test1()
    {
        Processor processor = new Processor();
        processor.execute("a = 2 * (2 + 1)");
        processor.execute("b = a++ + 2");

        assertTrue("'a' should be 7.", processor.checkVariable("a", 7));
        assertTrue("'b' should be 8.", processor.checkVariable("b", 8));
    }

    @Test()
    public void Test2()
    {
        Processor processor = new Processor();
        processor.execute("a = 3");
        processor.execute("b = 1 + a * 3 + 1");

        assertTrue("'a' should be 3.", processor.checkVariable("a", 3));
        assertTrue("'b' should be 11.", processor.checkVariable("b", 11));
    }

    @Test()
    public void Test3()
    {
        Processor processor = new Processor();
        processor.execute("a = 3");
        processor.execute("b =  a * (3 + 1)");

        assertTrue("'a' should be 3.", processor.checkVariable("a", 3));
        assertTrue("'b' should be 12.", processor.checkVariable("b", 12));
    }
}