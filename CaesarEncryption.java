import java.util.Scanner;

public class CaesarEncryption {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

     System.out.print("Enter plaintext: ");
     String plaintext = input.nextLine();

     System.out.print("Enter key: ");
     int key = input.nextInt();

     System.out.println("Plaintext: " + plaintext);
     System.out.println("Key: " + key);
      System.out.println("Ciphertext: " + encrypt(plaintext, key));
    }
    // Shift English letters; preserve case and all other characters.
  public static String encrypt(String plaintext, int key) {
    int shift = Math.floorMod(key, 26);// Normalize the key to a shift between 0 and 25.
    StringBuilder ciphertext = new StringBuilder();

    for (int i = 0; i < plaintext.length(); i++) {
        char letter = plaintext.charAt(i);

        if (letter >= 'A' && letter <= 'Z') {// Modulo 26 wraps letters back to the start of the alphabet.
            letter = (char) ('A' + (letter - 'A' + shift) % 26);
        } else if (letter >= 'a' && letter <= 'z') {
            letter = (char) ('a' + (letter - 'a' + shift) % 26);
        }

        ciphertext.append(letter);
    }

    return ciphertext.toString();
}  

}