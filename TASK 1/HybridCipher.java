import java.util.*;

public class HybridCipher {
    
    private static final int BLOCK_SIZE = 16;
    private static final int[] S_BOX = new int[256];
    private static final int[] REVERSE_S_BOX = new int[256];

    static {
        // Generate a simple non-linear S-Box
        for (int i = 0; i < 256; i++) {
            S_BOX[i] = (i * 197 + 21) % 256;
        }
        // Create a reverse S-Box for decryption
        for (int i = 0; i < 256; i++) {
            REVERSE_S_BOX[S_BOX[i]] = i;
        }
    }

    // Padding function to ensure text is a multiple of BLOCK_SIZE (16 bytes)
    private static String padText(String text) {
        int paddingLength = BLOCK_SIZE - (text.length() % BLOCK_SIZE);
        StringBuilder paddedText = new StringBuilder(text);
        for (int i = 0; i < paddingLength; i++) {
            paddedText.append((char) paddingLength); // PKCS7-like padding
        }
        return paddedText.toString();
    }

    // Remove padding after decryption
    private static String removePadding(String text) {
        int paddingLength = text.charAt(text.length() - 1);
        return text.substring(0, text.length() - paddingLength);
    }

    // Substitution step using S-Box
    private static byte[] substituteBytes(byte[] block) {
        byte[] substituted = new byte[block.length];
        for (int i = 0; i < block.length; i++) {
            substituted[i] = (byte) S_BOX[block[i] & 0xFF];
        }
        return substituted;
    }

    // Reverse substitution step using the reverse S-Box
    private static byte[] reverseSubstituteBytes(byte[] block) {
        byte[] reversed = new byte[block.length];
        for (int i = 0; i < block.length; i++) {
            reversed[i] = (byte) REVERSE_S_BOX[block[i] & 0xFF];
        }
        return reversed;
    }

    // Transposition step using matrix column shuffle
    private static byte[] transposeMatrix(byte[] block, List<Integer> key) {
        byte[] transposed = new byte[BLOCK_SIZE];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposed[i * 4 + j] = block[i * 4 + key.get(j)];
            }
        }
        return transposed;
    }

    // Reverse transposition step
    private static byte[] inverseTransposeMatrix(byte[] block, List<Integer> key) {
        byte[] transposed = new byte[BLOCK_SIZE];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposed[i * 4 + key.get(j)] = block[i * 4 + j]; // Reverse order
            }
        }
        return transposed;
    }

    // Generate a random transposition key
    private static List<Integer> generateKey() {
        List<Integer> key = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(key, new Random());
        return key;
    }

    public static byte[] hybridEncrypt(String plaintext, List<Integer> key) {
        plaintext = padText(plaintext);
        byte[] ciphertext = new byte[plaintext.length()];

        for (int i = 0; i < plaintext.length(); i += BLOCK_SIZE) {
            byte[] block = plaintext.substring(i, i + BLOCK_SIZE).getBytes();
            byte[] subBlock = substituteBytes(block); // Apply substitution
            byte[] transBlock = transposeMatrix(subBlock, key); // Apply transposition
            System.arraycopy(transBlock, 0, ciphertext, i, BLOCK_SIZE);
        }
        return ciphertext;
    }

    public static String hybridDecrypt(byte[] ciphertext, List<Integer> key) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length; i += BLOCK_SIZE) {
            byte[] block = Arrays.copyOfRange(ciphertext, i, i + BLOCK_SIZE);
            byte[] transBlock = inverseTransposeMatrix(block, key); // Reverse transposition
            byte[] subBlock = reverseSubstituteBytes(transBlock); // Reverse substitution
            plaintext.append(new String(subBlock));
        }
        return removePadding(plaintext.toString()); // Remove padding after decryption
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the message
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();

        // Generate a key
        List<Integer> key = generateKey();

        // Encrypt the message
        byte[] encrypted = hybridEncrypt(message, key);

        // Decrypt the message
        String decrypted = hybridDecrypt(encrypted, key);

        // Output the results
        System.out.println("\nOriginal: " + message);
        System.out.println("Encrypted: " + Arrays.toString(encrypted));
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}
