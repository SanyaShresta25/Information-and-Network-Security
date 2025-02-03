import java.util.Scanner;

public class CaesarCipher {
    
    // Encryption method
    public static String encrypt(String plaintext, int shift) {
        StringBuilder cipher = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            
            if (ch == ' ') {
                cipher.append(" ");
            } else if (Character.isUpperCase(ch)) {
                cipher.append((char) (((ch - 'A' + shift) % 26) + 'A'));
            } else {
                cipher.append((char) (((ch - 'a' + shift) % 26) + 'a'));
            }
        }
        
        return cipher.toString();
    }
    
    // Decryption method
    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plain = new StringBuilder();
        
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            
            if (ch == ' ') {
                plain.append(" ");
            } else if (Character.isUpperCase(ch)) {
                plain.append((char) (((ch - 'A' - shift + 26) % 26) + 'A'));
            } else {
                plain.append((char) (((ch - 'a' - shift + 26) % 26) + 'a'));
            }
        }
        
        return plain.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();
        
        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();
        
        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Cipher text is: " + ciphertext);
        
        String decryptedText = decrypt(ciphertext, shift);
        System.out.println("Decrypted text is: " + decryptedText);
        
        scanner.close();
    }
}
