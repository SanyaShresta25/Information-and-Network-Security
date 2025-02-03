# Hill Cipher Encryption 🔐

## Overview
The Hill Cipher is a matrix-based encryption technique that transforms plaintext into ciphertext using a fixed key matrix. It uses matrix multiplication and modulo 26 to encrypt blocks of text.

## Features ✨
- Converts plaintext to uppercase and removes spaces.
- Pads the plaintext with 'X' if its length is not divisible by the matrix size.
- Encrypts the plaintext using matrix multiplication with a predefined 3x3 key matrix.

## How It Works 🔍
1. **Input Plaintext:** The user enters plaintext.
2. **Key Matrix:** A fixed 3x3 key matrix is used for encryption.
3. **Preprocessing:** The plaintext is converted to uppercase and padded with 'X' if necessary.
4. **Encryption:** Each 3-character block of plaintext is encrypted using matrix multiplication with the key matrix.
5. **Output:** The resulting ciphertext is displayed after encryption.

## Example 💡
For example, if you input:
```
Enter plaintext: HELLO
```
The program will output:
```
Encrypted: UQXUB
```
## To run
https://onlinegdb.com/FK4ko6Z8j

## Usage 🚀
1. Clone or download this repository to your local machine.
2. Run the Java program in an IDE or terminal with Java support.
3. Enter your plaintext when prompted.
4. View the encrypted ciphertext displayed on the screen.

