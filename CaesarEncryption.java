
import java.util.Scanner;

public class CaesarEncryption {

    // Main method: reads user input and displays the encryption result.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the plaintext message from the user.
        System.out.print("Enter plaintext: ");
        String plaintext = input.nextLine();

        // Get the encryption key from the user.
        System.out.print("Enter key: ");
        int key = input.nextInt();

        // Display the original message, key, and encrypted message.
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Key: " + key);
        System.out.println("Ciphertext: " + encrypt(plaintext, key));
    }

    // Encrypts plaintext using the Caesar cipher with the given key.
    public static String encrypt(String plaintext, int key) {

        // Normalize the key to a shift between 0 and 25.
        // This also handles negative keys.
        int shift = Math.floorMod(key, 26);

        // Store the encrypted characters.
        StringBuilder ciphertext = new StringBuilder();

        // Process each character in the plaintext.
        for (int i = 0; i < plaintext.length(); i++) {
            char letter = plaintext.charAt(i);

            // Shift uppercase letters while preserving their case.
            if (letter >= 'A' && letter <= 'Z') {
                letter = (char) ('A' + (letter - 'A' + shift) % 26);

            // Shift lowercase letters while preserving their case.
            } else if (letter >= 'a' && letter <= 'z') {
                letter = (char) ('a' + (letter - 'a' + shift) % 26);
            }

            // Append the character to the result.
            // Spaces, numbers, and symbols remain unchanged.
            ciphertext.append(letter);
        }

        // Return the final encrypted message.
        return ciphertext.toString();
    }
}
