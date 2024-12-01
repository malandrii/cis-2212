// Andrii Malakhovtsev
// Passphrase Generator

import java.util.*;
import java.io.*;

/**
 * The PassphraseGenerator class asks the user to generate passphrases.
 * It uses the 'WordBank' class to get random words and form the passphrases using said words.
 */
public class PassphraseGenerator {
    private WordBank wordBank;

    /**
     * Constructor that initializes the PassphraseGenerator with a WordBank.
     * @param fileName path to the file containing words.
     */
    public PassphraseGenerator(String fileName) {
        try {
            wordBank = new WordBank(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found: " + fileName);
            System.exit(1);
        }
    }

    /**
     * Main logic for generating passphrases.
     */
    public void generatePassphrases() {
        Scanner input = new Scanner(System.in);

        while (true) {
            // Get user input for the number of passphrases, words per passphrase, and word size.
            int numPassphrases = getIntInput(input, "Please, enter the number of passphrases to generate: ");
            int numWords = getIntInput(input, "Please, enter the number of words per passphrase: ");
            int wordSize = getIntInput(input, "Please, enter the word size for the passphrases: ");

            // Check if there are words of the specified size
            if (!wordBank.containsSize(wordSize)) {
                System.out.println("Too big! No words of size " + wordSize + " were found in the file.");
                continue;
            }

            // Generate the passphrases
            for (int i = 0; i < numPassphrases; i++) {
                StringBuilder passphrase = new StringBuilder();
                for (int j = 0; j < numWords; j++) {
                    passphrase.append(wordBank.getRandomWord(wordSize));
                }
                System.out.println("Passphrase #" + (i + 1) + ": " + passphrase.toString().trim());
            }

            // Ask if the user wants to generate more passphrases
            System.out.print("Do you want to generate more passphrases? (Y/N): ");
            String response = input.next().toLowerCase();
            if (!response.equals("y")) {
                break;
            }
        }

        input.close();
    }

    /**
     * Gets validated integer input from the user.
     * @param input the Scanner object for reading input.
     * @param prompt the prompt message.
     * @return integer input.
     */
    private int getIntInput(Scanner input, String prompt) {
        int result = -1;
        while (result < 0) {
            System.out.print(prompt);
            try {
                result = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please make sure you are entering an integer.");
            }
        }
        return result;
    }
}
