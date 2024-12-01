// Andrii Malakhovtsev
// Passphrase Generator

import java.io.*;
import java.util.*;

/**
 * The 'WordBank' class manages a list of words loaded from a file.
 * It allows to get random words from a file. Specific size, checking if a word exists.
 */
public class WordBank {
    private final int LOAD_ALL_WORDS_SIZE = -1;
    private List<String> words = new ArrayList<>(); // List to store words
    private Set<Integer> wordSizes = new HashSet<>(); // Set to store unique word sizes
                                                      // (HashSet doesn't store same values)

    /**
     * Constructor that loads words from the file.
     * @throws FileNotFoundException if the file is not found.
     */
    public WordBank(String fileName) throws FileNotFoundException {
        loadWordsFromFile(fileName, LOAD_ALL_WORDS_SIZE); // Load all words initially
    }

    /**
     * Constructor that loads words of a size from the file.
     * @param fileName The path to the file containing words.
     * @param size The size of the words to be loaded (e.g., 5 for 5-letter words).
     * @throws FileNotFoundException if the file is not found.
     */
    public WordBank(String fileName, int size) throws FileNotFoundException {
        loadWordsFromFile(fileName, size);
    }

    /**
     * Loads words from a file and adds them to the list.
     * @param fileName is the path to the file containing words.
     * @param size is the size of the words to be loaded (-1 for all sizes, great for re-usage).
     * @throws FileNotFoundException if the file is not found.
     */
    private void loadWordsFromFile(String fileName, int size) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNextLine()) {
            String word = scanner.nextLine().trim();
            if (size == LOAD_ALL_WORDS_SIZE || word.length() == size) {
                words.add(word);
                wordSizes.add(word.length());
            }
        }

        scanner.close();
    }

    /**
     * Gets a random word from the word bank.
     * @return a random word from the list.
     */
    public String getRandomWord() {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    /**
     * Gets a random word of a specific size from the word bank.
     * @param size the size of the word to retrieve.
     * @return a random word of the specified size, or an empty string if no such word exists.
     */
    public String getRandomWord(int size) {
        if (!wordSizes.contains(size)) {
            return "";
        }

        List<String> wordsOfSize = new ArrayList<>();
        for (String word : words) {
            if (word.length() == size) {
                wordsOfSize.add(word);
            }
        }

        Random rand = new Random();
        return wordsOfSize.get(rand.nextInt(wordsOfSize.size()));
    }

    /**
     * Checks if a word exists in the word bank.
     * @param word the word to check.
     * @return True if the word is in the list, false - otherwise.
     */
    public boolean contains(String word) {
        return words.contains(word);
    }

    /**
     * Checks if there are any words of a specific size in the word bank.
     * @param size the size to check.
     * @return True if there are words of the specified size, false - otherwise.
     */
    public boolean containsSize(int size) {
        return wordSizes.contains(size);
    }
}
