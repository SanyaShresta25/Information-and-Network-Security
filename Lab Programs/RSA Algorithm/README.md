

# 🔐 RSA Encryption & Decryption in Python  

## 📜 Description  
This Python program implements the **RSA algorithm**, one of the most widely used public-key cryptographic techniques. It allows users to **encrypt and decrypt messages** using a pair of keys: **Public Key** and **Private Key**.  

## ✨ Features  
✅ **Generates Public and Private Keys** dynamically.  
✅ **Encrypts and decrypts** numerical messages using modular arithmetic.  
✅ Uses **two prime numbers (p, q)** for key generation.  
✅ Ensures **secure communication** using asymmetric encryption.  

## ⚙️ How It Works  
1. The user enters **two prime numbers** `p` and `q`.  
2. The program calculates:  
   - **n = p × q** (modulus)  
   - **φ(n) = (p-1) × (q-1)** (Euler’s totient function)  
3. A public exponent **e** is chosen such that `1 < e < φ(n)` and `gcd(e, φ(n)) = 1`.  
4. The private exponent **d** is computed using **modular inverse** of `e`.  
5. **Encryption:** `C = M^e mod n`  
6. **Decryption:** `M = C^d mod n`  
7. The original message is **successfully retrieved** after decryption.  

## 🛠 Code Explanation  
🔢 **gcd(a, b):** Finds the greatest common divisor (GCD) of two numbers.  
🔑 **Key Generation:** Computes **public and private keys** dynamically.  
🔐 **Encryption:** Converts the message into a ciphertext using modular exponentiation.  
🔓 **Decryption:** Recovers the original message using the private key.  

## 🎯 Example Run  
**Input:**  
```bash
Enter prime number p: 61
Enter prime number q: 53
Enter a message (in number format): 89
```
**Output:**  
```bash
Public Key (e, n): (17, 3233)
Private Key (d, n): (2753, 3233)
Encrypted Message: 1394
Decrypted Message: 89
```

## 🖥 Requirements  
🐍 **Python 3.x** installed.  
📝 A text editor or an IDE like **VS Code, PyCharm, or Jupyter Notebook**.  

## 🚀 Link to Run  
🔹 Run the program online:https://onlinegdb.com/HMT9997iL

## ⚠️ Notes  
⚡ The **message must be a number** (for simplicity).  
⚡ The **prime numbers (p, q) should be large** for better security.  
⚡ The **private key should remain confidential** to ensure encryption security. 
