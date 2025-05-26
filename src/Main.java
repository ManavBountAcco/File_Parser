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
        // Initialize a Set to store unique vowels
        Set<Character> uniqueVowels = new HashSet<>();

        // Split the input into words
        String[] words = input.split(" ");

        // Count of vowels
        int totalVowelsCount = 0;

        // Loop through each word
        for (String word : words) {
            // Check if the word starts with a vowel
            if (startsWithVowel(word)) {
                // Loop through each character of the word
                for (char c : word.toLowerCase().toCharArray()) {
                    // Check if the character is a vowel
                    if (isVowel(c)) {
                        // Add the vowel to the set (unique vowels)
                        uniqueVowels.add(c);
                        totalVowelsCount++;
                    }
                }
            }
        }

        // Write the unique vowels and total vowel count to the output file
        writeToFile(uniqueVowels, totalVowelsCount);
    }

    // Check if the word starts with a vowel
    public static boolean startsWithVowel(String word) {
        char firstChar = word.toLowerCase().charAt(0); // Get the first character of the word
        return "aeiou".indexOf(firstChar) != -1; // Check if it's a vowel
    }

    // Check if the character is a vowel
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1; // returns true if c is a vowel
    }

    public static void writeToFile(Set<Character> uniqueVowels, int totalVowelsCount) {
        // Output file path
        String filePath = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            // Write unique vowels
            writer.write("Unique Vowels: ");
            for (Character vowel : uniqueVowels) {
                writer.write(vowel + " ");
            }
            writer.newLine();

            // Write total count of vowels
            writer.write("Total Count of Vowels: " + totalVowelsCount);
            writer.newLine();

            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}