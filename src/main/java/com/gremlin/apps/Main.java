package com.gremlin.apps;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.gremlin.engine.Expression;
import com.gremlin.engine.Processor;

/**
 * @author Tom Everett
 */
class Main {
   public static void main(String[] args)  throws Exception  {
      
        // Check if there is a file argument
        if(args.length == 0) {
            System.out.println("Please provide a file argument.");
            return;
        }

        // Get file
        File file =  new File(args[0]); 

        // If there is a valid file
        if(file.exists() && !file.isDirectory()) { 

            // Create the file scanner
            Scanner scanner = new Scanner(file);

            // The arithmetic processor
            Processor processor = new Processor();
            
            // The current line from the console
            String line = null;

            // Read next line and process or exit
            while((line = readLine(scanner)) != null)
            {
                // Evaluate line
                Expression result = processor.execute(line);
                if(!Expression.isEmpty(result))
                {
                    // Print the value of the evaluated expression
                    System.out.println(result);
                }
            } 

            // Write the processor state
            System.out.println(processor.debug());
        }
        else {
            System.out.println("Please provide a valid file.");
        }

   }

    /**
     * Reads the next line from the user.
     * @return A single line.
     */
    private static String readLine(Scanner scanner) {
        
        if(!scanner.hasNext()) {
            return null;
        }

        String line = scanner.nextLine();
        if(line != null) {
            // normalize line
            line = line.trim();
        }
        
        return line;
    }
}