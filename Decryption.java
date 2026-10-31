public class Decryption {
     // this method decrypts the ciphertext using the given caeser cypher key
    public static String decrypt(String ciphertext, int key) {
        // convert the key to a shift from 0 to 25
        int shift = Math.floorMod(key, 26);
        // the decrypted characters are stored here
        StringBuilder plaintext = new StringBuilder();

        // go through every character in the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            char letter = ciphertext.charAt(i);

            // check if the character is an uppercase english letter
            if (letter >= 'A' && letter <= 'Z') {
                
                 // find letter's position from 0 to 25 then subtract the shift
                // add 26 to prevent a negative remainder
                // % 26 to wrap around and + 'A' to cast to char to get the uppercase letter
                letter = (char) ('A' + (letter - 'A' - shift + 26) % 26);
            }
          
             // check if the character is a lowercase english letter
            else if (letter >= 'a' && letter <= 'z') {
                // follow same steps for lowercase
                letter = (char) ('a' + (letter - 'a' - shift + 26) % 26);
            }

            // add character to the result and keep spaces, numbers, and punctuation unchanged
            plaintext.append(letter);
        }

        // return the completed message as a string
        return plaintext.toString();
    }
}
