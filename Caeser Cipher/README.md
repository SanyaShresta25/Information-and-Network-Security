# 🔐 Caesar Cipher in Java

## 📜 Description
This Java program implements the **Caesar Cipher** encryption and decryption techniques. The program allows users to enter a plaintext message and a shift value, which determines how many positions each letter in the text will be shifted in the alphabet.

## ✨ Features
- 🔒 Encrypts a given text using the Caesar cipher technique.
- 🔑 Decrypts the ciphered text back to its original form.
- 🅰️ Works for both uppercase and lowercase letters.
- 🏛 Maintains spaces in the original text.

## ⚙️ How It Works
1. 📝 The user provides a plaintext message.
2. 🔢 The user specifies a shift value (key) for the encryption.
3. 🔄 The program encrypts the plaintext using the Caesar cipher.
4. 📜 The encrypted text is displayed.
5. 🔄 The program then decrypts the encrypted text using the same shift value.
6. 📝 The decrypted text (original message) is displayed.

## 🛠 Code Explanation
- 🔐 `encrypt(String plaintext, int shift)`: Encrypts the given text by shifting characters forward in the alphabet.
- 🔓 `decrypt(String ciphertext, int shift)`: Decrypts the given text by shifting characters backward in the alphabet.
- 🎯 `main(String[] args)`: Handles user input, calls the encryption and decryption methods, and prints results.

## 💡 Example Run
**Input:**
```
Enter the plaintext: hello world
Enter the shift value: 3
```

**Output:**
```
Cipher text is: khoor zruog
Decrypted text is: hello world
```

## 🖥 Requirements
- ☕ Java Development Kit (JDK) installed.
- 🖊 A text editor or an IDE like IntelliJ IDEA, Eclipse, or VS Code.

## 🚀 How to Run
1. 📂 Clone this repository:
   ```sh
   git clone https://github.com/your-username/CaesarCipher.git
   cd CaesarCipher
   ```
2. 🏗 Compile the program:
   ```sh
   javac CaesarCipher.java
   ```
3. ▶️ Run the program:
   ```sh
   java CaesarCipher
   ```
4. 🖥 Follow the on-screen prompts to enter text and shift values.

## ⚠️ Notes
- 🔠 The program only shifts alphabetical characters; spaces remain unchanged.
- 🔢 The shift value should be a positive integer.
- 🔄 The decryption process reverses the shift to retrieve the original message.



