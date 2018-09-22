package com.gremlin.apps;

import java.util.Scanner;

import com.gremlin.engine.Expression;
import com.gremlin.engine.ExpressionResult;
import com.gremlin.engine.Processor;

/**
 * @author Tom Everett
 */
class Main {
   public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        // The arithmetic processor
        Processor processor = new Processor();
        
        // The current line from the console
        String line = null;

        // Read next line and process or exit
        while((line = readLine(scanner)) != "exit")
        {
            // Evaluate line
            Expression result = processor.evaluate(line);
            if(result != null)
            {
                // Print the value of the evaluated expression
                System.out.println(result);
            }
        } 

        // Write the processor state
        System.out.println(processor.debug());

        // Pause
        System.out.println("Press enter to quit.");
        scanner.nextLine();
   }

    /**
     * Reads the next line from the user.
     * @return A single line.
     */
    private static String readLine(Scanner scanner) {
        
        String line = scanner.nextLine();
        if(line != null) {
            // normalize line
            line = line.trim();
        }
        
        return line;
    }
}