public class Decryption {

    public static String decrypt(String ciphertext, int key) {
        // Convert the key to an equivalent shift between 0 and 25
        int shift = Math.floorMod(key, 26);
        // Build the decrypted message one character at a time
        StringBuilder plaintext = new StringBuilder();

        // Go through every character in the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            // Get the character at the current position.
            char letter = ciphertext.charAt(i);

            // Check if the character is an uppercase english letter
            if (letter >= 'A' && letter <= 'Z') {
                
                 // Convert to 0–25, subtract the shift, wrap, and convert back
                // Adding 26 prevents a negative remainder
                letter = (char) ('A' + (letter - 'A' - shift + 26) % 26);
            }
          
             // Check if the character is a lowercase English letter
            else if (letter >= 'a' && letter <= 'z') {
                letter = (char) ('a' + (letter - 'a' - shift + 26) % 26);
            }

            // Keep spaces, numbers, and punctuation unchanged
            plaintext.append(letter);
        }

        // Convert the completed message to a String and return it
        return plaintext.toString();
    }
}
