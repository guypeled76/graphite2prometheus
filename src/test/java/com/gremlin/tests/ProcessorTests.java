package com.gremlin.tests;

import static org.junit.Assert.assertTrue;
import com.gremlin.engine.*;
import org.junit.Test;

public class ProcessorTests
{
    
    @Test()
    public void givenExample()
    {
        Processor processor = new Processor();
        processor.execute("i = 0");
        processor.execute("j = ++i");
        processor.execute("x = i++ + 5");
        processor.execute("y = 5 + 3 * 10");
        processor.execute("i += y");
        
        // Create the output string
        // String output = processor.debug();

        // (i=37,j=1,x=6,y=35)
        assertTrue("'i' should be 37.", processor.checkVariable("i", 37));
        assertTrue("'j' should be 1.", processor.checkVariable("j", 1));
        assertTrue("'x' should be 6.", processor.checkVariable("x", 6));
        assertTrue("'y' should be 35.", processor.checkVariable("y", 35));
    }

    @Test()
    public void divisionTest()
    {
        Processor processor = new Processor();
        processor.execute("a = 6 / 3 + 1");
        processor.execute("b = 6 / (3 - 1)");

        assertTrue("'a' should be 2.", processor.checkVariable("a", 3));
        assertTrue("'b' should be 3.", processor.checkVariable("b", 3));
    }

    @Test()
    public void powerTest()
    {
        Processor processor = new Processor();
        processor.execute("a = 3 * 3 ^ 2 + 2");

        assertTrue("'a' should be 29.", processor.checkVariable("a", 29));
    }

    @Test()
    public void testPlusEqual()
    {
        Processor processor = new Processor();
        processor.execute("a = 3");
        processor.execute("a += 3");

        assertTrue("'a' should be 6.", processor.checkVariable("a", 6));
    }

    @Test()
    public void parenthesesTest()
    {
        Processor processor = new Processor();
        processor.execute("a = 3");
        processor.execute("b =  a * (3 + 1)");

        assertTrue("'a' should be 3.", processor.checkVariable("a", 3));
        assertTrue("'b' should be 12.", processor.checkVariable("b", 12));
    }

    @Test()
    public void minusTest()
    {
        Processor processor = new Processor();
        processor.execute("a = -3");
        processor.execute("b =  a * 2");

        assertTrue("'a' should be -3.", processor.checkVariable("a", -3));
        assertTrue("'b' should be -6.", processor.checkVariable("b", -6));
    }
}