package com.gremlin.tests;

import static org.junit.Assert.assertTrue;
import com.gremlin.engine.*;
import org.junit.Test;

public class ProcessorTests
{
    
    @Test()
    public void givenExample() throws Exception 
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
    public void divisionTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 6 / 3 + 1");
        processor.execute("b = 6 / (3 - 1)");

        assertTrue("'a' should be 2.", processor.checkVariable("a", 3));
        assertTrue("'b' should be 3.", processor.checkVariable("b", 3));
    }

    @Test()
    public void powerTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 3 * 3 ^ 2 + 2");

        assertTrue("'a' should be 29.", processor.checkVariable("a", 29));
    }

    @Test()
    public void plusEqualTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 3");
        processor.execute("a += 3");

        assertTrue("'a' should be 6.", processor.checkVariable("a", 6));
    }

    @Test()
    public void parenthesesTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 3");
        processor.execute("b =  a * (3 + 1)");

        assertTrue("'a' should be 3.", processor.checkVariable("a", 3));
        assertTrue("'b' should be 12.", processor.checkVariable("b", 12));
    }

    @Test()
    public void minusTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = -3");
        processor.execute("b =  a * 2");

        assertTrue("'a' should be -3.", processor.checkVariable("a", -3));
        assertTrue("'b' should be -6.", processor.checkVariable("b", -6));
    }

    @Test()
    public void moduloTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 6");
        processor.execute("b =  a % 4");

        assertTrue("'a' should be 6.", processor.checkVariable("a", 6));
        assertTrue("'b' should be 2.", processor.checkVariable("b", 2));
    }


    @Test()
    public void hexTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 0xAFF + 1");
        processor.execute("b =  a + 2");

        assertTrue("'a' should be 2816.", processor.checkVariable("a", 2816));
        assertTrue("'b' should be 2818.", processor.checkVariable("b", 2818));
    }

    @Test()
    public void dotTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 0.5");
        processor.execute("b =  a + 2");

        assertTrue("'a' should be 0.5.", processor.checkVariable("a", 0.5));
        assertTrue("'b' should be 2.5.", processor.checkVariable("b", 2.5));
    }


    @Test()
    public void scientificTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = 2E-2");
        processor.execute("b =  a * 10");

        assertTrue("'a' should be 0.02.", processor.checkVariable("a", 0.02));
        assertTrue("'b' should be 0.2.", processor.checkVariable("b", 0.2));
    }

    @Test()
    public void sinTest() throws Exception 
    {
        Processor processor = new Processor();
        processor.execute("a = sin(2)");
       
        assertTrue("'a' should be 0.9092974268256817.", processor.checkVariable("a", 0.9092974268256817));
        

    }
}