// Andrii Malakhovtsev
// Passphrase Generator

import java.io.File;

/**
 * Main function where the input starts and filePath is determined.
 */
public class Main {
    public static void main(String[] args) {

        String filePath = System.getProperty("user.dir") + File.separator + "Project 4" + File.separator +
                "src" + File.separator + "words.txt"; // Enter your file path

        System.out.println("Random Passpharse Generator\n");

        System.out.println("This program will generate passphrases made up of random words of a specified size.\n");

        PassphraseGenerator generator = new PassphraseGenerator(filePath);
        generator.generatePassphrases();
    }
}
