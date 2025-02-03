import java.util.Scanner;

public class HillCipher {
    public static String encrypt(String plaintext, int[][] keyMatrix) {
        int n = keyMatrix.length;
        plaintext = plaintext.toUpperCase().replace(" ", "");
        
        // Padding if needed
        while (plaintext.length() % n != 0) {
            plaintext += "X";
        }
        
        StringBuilder ciphertext = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i += n) {
            int[] block = new int[n];
            for (int j = 0; j < n; j++) {
                block[j] = plaintext.charAt(i + j) - 'A';
            }
            
            int[] result = new int[n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    result[r] += keyMatrix[r][c] * block[c];
                }
                result[r] %= 26;
            }
            
            for (int num : result) {
                ciphertext.append((char) (num + 'A'));
            }
        }
        
        return ciphertext.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input for plaintext
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        
        // Define key matrix
        int[][] keyMatrix = {
            {6, 24, 1},
            {13, 16, 10},
            {20, 17, 15}
        };
        
        System.out.println("Using predefined key matrix:");
        for (int i = 0; i < keyMatrix.length; i++) {
            for (int j = 0; j < keyMatrix[i].length; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
        
        System.out.println("Encrypted: " + encrypt(plaintext, keyMatrix));
    }
}
