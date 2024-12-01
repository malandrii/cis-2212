// Andrii Malakhovtsev
// Passphrase Generator

public class Main {
    /**
     * Main method to drive the application.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Replace this with the actual path to the word list file
        PassphraseGenerator generator = new PassphraseGenerator("words.txt");
        generator.generatePassphrases();
    }
}
