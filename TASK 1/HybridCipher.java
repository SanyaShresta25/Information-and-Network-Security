import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HybridCipher {

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

    private static String padText(String text) {
        while (text.length() % 16 != 0) {
            text += " ";
        }
        return text;
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
        byte[] transposed = new byte[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposed[i * 4 + j] = block[i * 4 + key.get(j)];
            }
        }
        return transposed;
    }

    private static List<Integer> generateKey() {
        List<Integer> key = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(key, new Random());
        return key;
    }

    public static byte[] hybridEncrypt(String plaintext, List<Integer> key) {
        plaintext = padText(plaintext);
        byte[] ciphertext = new byte[plaintext.length()];
        for (int i = 0; i < plaintext.length(); i += 16) {
            byte[] block = plaintext.substring(i, i + 16).getBytes();
            byte[] subBlock = substituteBytes(block); // Apply substitution
            byte[] transBlock = transposeMatrix(subBlock, key); // Apply transposition
            System.arraycopy(transBlock, 0, ciphertext, i, 16);
        }
        return ciphertext;
    }

    public static String hybridDecrypt(byte[] ciphertext, List<Integer> key) {
        StringBuilder plaintext = new StringBuilder();
        List<Integer> inverseKey = Arrays.asList(new Integer[4]);
        for (int i = 0; i < 4; i++) {
            inverseKey.set(key.get(i), i);
        }

        for (int i = 0; i < ciphertext.length; i += 16) {
            byte[] block = Arrays.copyOfRange(ciphertext, i, i + 16);
            byte[] transBlock = transposeMatrix(block, inverseKey); // Reverse transposition
            byte[] subBlock = reverseSubstituteBytes(transBlock); // Reverse substitution
            plaintext.append(new String(subBlock).trim());
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
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
        System.out.println("Original: " + message);
        System.out.println("Encrypted: " + Arrays.toString(encrypted));
        System.out.println("Decrypted: " + decrypted);

        // Close the scanner
        scanner.close();
    }
}