package com.gremlin.apps;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import com.gremlin.apps.ArithmeticParser.EquationContext;
import com.gremlin.engine.Processor;

/**
 * @author Tom Everett
 */
class Main {
   public static void main(String[] args) {
      
        // The arithmetic processor
        Processor processor = new Processor();
        
        // The current line from the console
        String line = null;

        // Read next line and process or exit
        while((line = readLine()) != "exit")
        {
            // Execute line
            Object value = processor.Execute(line);
            if(value != null)
            {
                // Print the value of the executed expression
                System.out.println(value);
            }
        } 
   }

    /**
     * Reads the next line from the user.
     * @return A single line.
     */
    private static String readLine() {
        String line = System.console().readLine();
        if(line != null) {
            // normalize line
            line = line.trim();
        }
        
        return line;
    }
}