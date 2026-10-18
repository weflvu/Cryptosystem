
public class Cryptanalysis {

    public static Integer knownPlaintextAttack(String plaintext, String ciphertext) {

        plaintext = plaintext.toUpperCase();
        ciphertext = ciphertext.toUpperCase();

        if (plaintext.length() != ciphertext.length()) {
            return null;
        }

        Integer key = null;

        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char c = ciphertext.charAt(i);

            if (p >= 'A' && p <= 'Z' && c >= 'A' && c <= 'Z') {
                int shift = (c - p + 26) % 26;

                if (key == null) {
                    key = shift;
                } else if (key != shift) {
                    return null;
                }
// if not eng letter check if the same, if not return null
            } else if (p != c) {
                return null;
            }
        }

        return key;
    }

    
