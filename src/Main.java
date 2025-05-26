import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String[] args)  throws IOException {
                Path filePath = Path.of(".//input.txt");
                String content = Files.readString(filePath);
                System.out.println(content);
        //code to read and generate By manav>
        //Approach : -> String -> O(n) read -> Add in Set -> add in output.txt if not generate else overwrite

        String input = content; // Example input

        // Call the process method
        processInput(input);


    }

    public static void processInput(String input) {
        // Initialize a Set to store unique words starting with a vowel
        Set<String> uniqueWords = new HashSet<>();

        // Initialize a variable to track the total count of words starting with a vowel
        int totalVowelStartingWordsCount = 0;

        // Split the input into words
        String[] words = input.split(" ");

        // Loop through each word
        for (String word : words) {
            // Check if the word starts with a vowel
            if (startsWithVowel(word)) {
                // Add the word to the set (unique words)
                uniqueWords.add(word.toLowerCase()); // Ensure case-insensitivity
                totalVowelStartingWordsCount++;
            }
        }

        // Write the unique words and counts to the output file
        writeToFile(uniqueWords, totalVowelStartingWordsCount, words.length);
    }

    // Check if the word starts with a vowel
    public static boolean startsWithVowel(String word) {
        char firstChar = word.toLowerCase().charAt(0); // Get the first character of the word
        return "aeiou".indexOf(firstChar) != -1; // Check if it's a vowel
    }

    public static void writeToFile(Set<String> uniqueWords, int totalVowelStartingWordsCount, int totalWordCount) {
        // Output file path
        String filePath = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            // Write unique words that start with a vowel
            writer.write("Unique Words Starting with Vowels: ");
            for (String word : uniqueWords) {
                writer.write(word + " ");
            }
            writer.newLine();

            // Write the total count of words starting with a vowel
            writer.write("Total Count of Words Starting with Vowels: " + totalVowelStartingWordsCount);
            writer.newLine();

            // Write the total word count (including duplicates)
            writer.write("Total Word Count: " + totalWordCount);
            writer.newLine();

            System.out.println("Data written to output.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}