package com.gremlin.apps;

import com.gremlin.engine.ExpressionResult;
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
            // Evaluate line
            ExpressionResult result = processor.evaluate(line);
            if(result != null)
            {
                // Print the value of the evaluated expression
                System.out.println(result);
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