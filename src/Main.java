import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Code to parse By anish

        //code to read and generate By manav>
        //Approach : -> String -> O(n) read -> Add in Set -> add in output.txt if not generate else overwrite

        String input = "By Anish\nBy Manav\nBy Anish\nBy Manav\nBy John\n"; // Example input

        // Call the process method
        processInput(input);


    }

    public static void processInput(String input) {
        // Initialize a Set to store unique strings
        Set<String> uniqueStrings = new HashSet<>();

        // Split the input into lines
        String[] lines = input.split("\n");

        // Add each line to the Set (duplicates will be ignored)
        for (String line : lines) {
            uniqueStrings.add(line.trim());  // trim() to avoid leading/trailing spaces
        }

        // Write the unique strings to the output file
        writeToFile(uniqueStrings);
    }

    public static void writeToFile(Set<String> uniqueStrings) {
        // Output file path
        String filePath = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            // Overwrite or create the file
            for (String uniqueString : uniqueStrings) {
                writer.write(uniqueString);
                writer.newLine();
            }
            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}