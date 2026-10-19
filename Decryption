public class Decryption {

    public static String decrypt(String ciphertext, int key) {
        // Normalize the key to a shift between 0 and 25.
        int shift = Math.floorMod(key, 26);
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char letter = ciphertext.charAt(i);

            // Shift uppercase English letters backward.
            if (letter >= 'A' && letter <= 'Z') {
                letter = (char) ('A' + (letter - 'A' - shift + 26) % 26);
            }
            // Shift lowercase English letters backward.
            else if (letter >= 'a' && letter <= 'z') {
                letter = (char) ('a' + (letter - 'a' - shift + 26) % 26);
            }

            // Keep spaces, numbers, and punctuation unchanged.
            plaintext.append(letter);
        }

        return plaintext.toString();
    }
}
