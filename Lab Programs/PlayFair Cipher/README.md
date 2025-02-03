# 🔐 Playfair Cipher in Java

## 📜 Description
This Java program implements the **Playfair Cipher**, a classic encryption technique that encrypts pairs of letters in a digraph substitution method. The program processes a given plaintext using a keyword and generates an encrypted ciphertext based on a 5x5 matrix.

## Features
- Encrypts a given text using the Playfair cipher technique.
- Handles repeated letters and appends 'X' where necessary.
- Processes only alphabetical characters and converts 'J' to 'I'.
- Uses a 5x5 matrix generated from a unique keyword.

## How It Works
1. The user provides a plaintext message and a keyword.
2. A 5x5 matrix is generated using the keyword, ensuring unique letters.
3. The plaintext is preprocessed to remove duplicate consecutive letters and ensure an even number of characters.
4. The text is encrypted based on Playfair Cipher rules.
5. The encrypted text is displayed as ciphertext.

## 🛠 Code Explanation
- `createMatrix(String key)`: Generates a 5x5 matrix using the given key.
- `findPosition(char[][] matrix, char c)`: Finds the row and column position of a character in the matrix.
- `preprocess(String plaintext)`: Formats the plaintext by replacing 'J' with 'I', inserting 'X' between duplicate letters, and ensuring even-length text.
- `playfairEncrypt(String plaintext, String key)`: Encrypts the processed plaintext using the matrix.
- `main(String[] args)`: Handles user input and executes the encryption process.

## 💡 Example Run
**Input:**
```
Enter the plaintext: HELLO WORLD
Enter the key: KEYWORD
```

**Output:**
```
Ciphertext: ZEBBW VXGML
```

## Requirements
- Java Development Kit (JDK) installed.
- A text editor or an IDE like IntelliJ IDEA, Eclipse, or VS Code.

## How to Run
1. Clone this repository:
   ```sh
   git clone https://github.com/SanyaShresta25/PlayfairCipher.git
   cd PlayfairCipher
   ```
2. Compile the program:
   ```sh
   javac PlayfairCipher.java
   ```
3. Run the program:
   ```sh
   java PlayfairCipher
   ```
4. Follow the on-screen prompts to enter text and key for encryption.

## Notes
- The program only encrypts alphabetical characters; spaces are ignored.
- The letter 'J' is replaced with 'I' to fit the 5x5 matrix.
- If two identical letters appear in a pair, an 'X' is inserted between them.
- If the plaintext has an odd number of characters, an 'X' is appended at the end.

