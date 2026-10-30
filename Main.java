import java.util.Scanner;


	public class Main {
	public static void main(String []args) {
		
		    Scanner scanner = new Scanner(System.in);
		    boolean running = true;
	        // Display the menu until the user exits
		    while (running) {
		        System.out.println("-------------------------");
		        System.out.println(" Caesar Cipher System");
		        System.out.println("1- Encryption");
		        System.out.println("2- Decryption");
		        System.out.println("3- Cryptanalysis");
		        System.out.println("4- Exit");
		        System.out.print("Select your choice: ");

		        String choice = scanner.nextLine().trim();

		        switch (choice) {
                // Encrypt plaintext using the given key
		            case "1":
		                System.out.print("Enter a  plaintext: ");
		                String Ptext = scanner.nextLine();

		                if (Ptext.isEmpty()) {
		                    System.out.println("Error, it's an empty text ");
		                    break;
		                }

		                int encKey = readKey(scanner);
		             // Perform Caesar cipher encryption

		                String encrypted =
		                		CaesarEncryption.encrypt(Ptext, encKey);

		                System.out.println("Ciphertext: " + encrypted);
		                break;
		                // Decrypt ciphertext using the given key
		            case "2":
		                System.out.print("Enter ciphertext: ");
		                String ciphtext = scanner.nextLine();

		                if (ciphtext.isEmpty()) {
		                    System.out.println("Error, it's an empty text ");
		                    break;
		                }

		                int decKey = readKey(scanner);
		             // Perform Caesar cipher decryption
		                String decrypted =
		                    Decryption.decrypt(ciphtext, decKey);

		                System.out.println("Plaintext: " + decrypted);
		                break;
		                // Recover the key using a known plaintext attack

		            case "3":
		                System.out.print("Enter known plaintext: ");
		                String knPlaint = scanner.nextLine();

		                System.out.print("Enter corresponding ciphertext: ");
		                String knCiphert = scanner.nextLine();
		             // Check that both texts are provided for cryptanalysis
		                if (knPlaint.isEmpty() ||
		                    knCiphert.isEmpty()) {
		                    System.out.println("Error, it's an empty text ");
		                    break;
		                }
		             // Attempt to recover the encryption key
		                Integer recKey = Cryptanalysis.knownPlaintextAttack(
	    knPlaint, knCiphert
	);
		             // Display the recovered key if the attack succeeds

	if (recKey == null) {
	    System.out.println("Could not recover a key");
	} else {
	    System.out.println("Recovered Key: " + recKey);
	}
		                break;

		            case "4":
		                System.out.println("Exit !");
		                running = false;
		                break;

		            default:
		                System.out.println(
		                    "Invalid choice, try again from 1-4"
		                );
		        }
		    }

		    scanner.close();
		}
    // Validate that the key is an integer between 0 and 25

		public static int readKey(Scanner scanner) {
		    while (true) {
		        System.out.print("Enter key from 0-25 : ");
		        String input = scanner.nextLine().trim();

		        try {
		            int k = Integer.parseInt(input);

		            if (k >= 0 && k <= 25) {
		                return k;
		            }

		            System.out.println(
		                "Invalid key,  please try a number from 0-25"
		            );
		         // Handle invalid inputs that are not integers

		        } catch (NumberFormatException e) {
		            System.out.println(
		                "Invalid input, Please try to enter an integer"
		            );
		        }
		    }
		}
		

	}

