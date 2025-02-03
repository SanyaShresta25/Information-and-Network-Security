import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonoCipher {
    static Map<Character, Character> hashMap = new HashMap<>();

    public static String encrypt(String msg) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            ciphertext.append(hashMap.getOrDefault(ch, ch)); 
        }
        return ciphertext.toString();
    }

    public static String decrypt(String msg) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            plaintext.append(hashMap.getOrDefault(ch, ch)); 
        }
        return plaintext.toString();
    }

    public static void hashFn(String a, String b) {
        hashMap.clear();
        for (int i = 0; i < a.length(); i++) {
            hashMap.put(a.charAt(i), b.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String substitution = "qwertyuiopasdfghjklzxcvbnm";

        System.out.print("Enter the message to encrypt: ");
        String msg = scanner.nextLine().toLowerCase(); 

        hashFn(alphabet, substitution);
        String cipher = encrypt(msg);
        System.out.println("Encrypted Cipher Text: " + cipher);

        hashFn(substitution, alphabet);
        String plain = decrypt(cipher);
        System.out.println("Decrypted Plain Text: " + plain);

        scanner.close();
    }
}
