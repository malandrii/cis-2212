// Andrii Malakhovtsev
// Passphrase Generator

public class Main {
    public static void main(String[] args) {
        PassphraseGenerator generator = new PassphraseGenerator("words.txt");
        generator.generatePassphrases();
    }
}
