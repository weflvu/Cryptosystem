
public class Cryptanalysis {
    //this method calculates the key, if the key cannot be determined it returns null
    public static Integer knownPlaintextAttack(String plaintext, String ciphertext) {
        // turn both p and c to capital letters
        plaintext = plaintext.toUpperCase();
        ciphertext = ciphertext.toUpperCase();

        //if p and c have different lengths return null
        if (plaintext.length() != ciphertext.length()) {
            return null;
        }

        //create the variable key and set it to null
        Integer key = null;

        //loop over each letter in p and c
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char c = ciphertext.charAt(i);

            //checks if the letters are in the range A to Z
            if (p >= 'A' && p <= 'Z' && c >= 'A' && c <= 'Z') {
                // Calculate the shift for the current pair of letters
                int shift = (c - p + 26) % 26;

                //if the key was still null place the first shift as the key
                if (key == null) {
                    key = shift;

                // compare each new shift with the stored key
                // If they are different return null, otherwise continue to the next pair
                } else if (key != shift) {
                    return null;
                }
            // if the character isn't in english check if it is the same in p and c, if not return null
            } else if (p != c) {
                return null;
            }
        }

        return key;
    }

    
