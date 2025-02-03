# 🔐 Monoalphabetic Cipher in Java

## 📜 Description
This Java program implements the **Monoalphabetic Substitution Cipher** encryption and decryption techniques. It allows users to encrypt a given message using a predefined substitution mapping and decrypt it back to its original form.

## Features
- Encrypts a given text using a monoalphabetic substitution cipher.
- Decrypts the encrypted text back to its original message.
- Supports case-insensitive encryption and decryption.
- Uses a predefined substitution mapping for letter replacement.

## How It Works
1. The user provides a plaintext message.
2. A predefined substitution alphabet is used to replace each letter in the message.
3. The encrypted text is displayed.
4. The program reverses the substitution to decrypt the message back to plaintext.

## 🛠 Code Explanation
- 🔐 `encrypt(String msg)`: Encrypts the message by replacing each character using the predefined mapping.
- 🔓 `decrypt(String msg)`: Decrypts the message by reversing the mapping.
- 🔄 `hashFn(String a, String b)`: Generates the mapping between original and substituted alphabets.
- 🎯 `main(String[] args)`: Handles user input, calls encryption and decryption functions, and displays results.

## 💡 Example Run
**Input:**
```
Enter the message to encrypt: hello world
```

**Output:**
```
Encrypted Cipher Text: itssg vgksr
Decrypted Plain Text: hello world
```

## Requirements
- Java Development Kit (JDK) installed.
- A text editor or an IDE like IntelliJ IDEA, Eclipse, or VS Code.

## How to Run
1. Clone this repository:
   ```sh
   git clone https://github.com/SanyaShresta25/MonoCipher.git
   cd MonoCipher
   ```
2. Compile the program:
   ```sh
   javac MonoCipher.java
   ```
3. Run the program:
   ```sh
   java MonoCipher
   ```
4. Follow the on-screen prompts to enter text for encryption and decryption.

## Link to Run
https://onlinegdb.com/6JQtpuADT

## Notes
- The program only substitutes alphabetical characters; spaces remain unchanged.
- The predefined substitution alphabet must be a permutation of the original alphabet.
- The same mapping is required for both encryption and decryption.

