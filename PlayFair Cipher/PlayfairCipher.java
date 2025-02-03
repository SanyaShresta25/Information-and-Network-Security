import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PlayfairCipher {

    private static char[][] createMatrix(String key) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; // J is excluded
        key = key.toUpperCase().replace("J", "I");
        Set<Character> seen = new LinkedHashSet<>();

    for (int i = 0; i < key.length(); i++) {
    char c = key.charAt(i);
    if (Character.isLetter(c)) {
        seen.add(c);
    }
}

for (int i = 0; i < alphabet.length(); i++) {
    char c = alphabet.charAt(i);
    //If the character c is not present in the seen collection
    if (!seen.contains(c)) {
        seen.add(c);
    }
}

        char[][] matrix = new char[5][5];
        Iterator<Character> it = seen.iterator();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = it.next();
            }
        }
        return matrix;
    }

    private static int[] findPosition(char[][] matrix, char c) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (matrix[row][col] == c) {
                    return new int[]{row, col};
                }
            }
        }
        return null; // Should never reach here
    }

    private static String preprocess(String plaintext) {
        plaintext = plaintext.toUpperCase().replace("J", "I");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char current = plaintext.charAt(i);
            if (i < plaintext.length() - 1 && current == plaintext.charAt(i + 1)) {
                result.append(current).append('X');
            } else {
                result.append(current);
            }
        }

        if (result.length() % 2 != 0) {
            result.append('X');
        }

        return result.toString();
    }

    private static String playfairEncrypt(String plaintext, String key) {
        char[][] matrix = createMatrix(key);
        plaintext = preprocess(plaintext);

        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += 2) {
            char a = plaintext.charAt(i);
            char b = plaintext.charAt(i + 1);

            int[] pos1 = findPosition(matrix, a);
            int[] pos2 = findPosition(matrix, b);

            if (pos1[0] == pos2[0]) { // Same row
                ciphertext.append(matrix[pos1[0]][(pos1[1] + 1) % 5]);
                ciphertext.append(matrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) { // Same column
                ciphertext.append(matrix[(pos1[0] + 1) % 5][pos1[1]]);
                ciphertext.append(matrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else { // Rectangle rule
                ciphertext.append(matrix[pos1[0]][pos2[1]]);
                ciphertext.append(matrix[pos2[0]][pos1[1]]);
            }
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        String ciphertext = playfairEncrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

        scanner.close();
    }
}
