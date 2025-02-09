# Hybrid Cipher - Secure Encryption System

## Introduction
This Hybrid Cipher is an encryption system that combines **Substitution** and **Transposition** techniques to provide a strong encryption mechanism. By integrating an AES-like **Substitution Box (S-Box)** and a **key-based transposition method**, this cipher achieves **128-bit encryption strength** and ensures high security against cryptanalysis attacks.

---

## Features
✅ **128-bit encryption strength** – Uses a **128-bit key** to ensure brute-force infeasibility.  
✅ **Hybrid of Substitution & Transposition** – Ensures both **confusion** and **diffusion** for added security.  
✅ **Dynamic S-Box** – Prevents frequency analysis and algebraic attacks.  
✅ **Multi-Round Encryption (10 Rounds)** – Enhances security by iterative transformation.  
✅ **Randomized Transposition** – Prevents pattern recognition attacks.  
✅ **Fast & Efficient** – Optimized for modern software implementations.  

---

## How It Works
### 🔹 **Substitution Layer (Confusion)**
- Uses a **key-dependent non-linear S-Box**, inspired by AES.
- Each byte is substituted with a dynamically generated value.
- Prevents frequency analysis attacks and ensures security.

### 🔹 **Transposition Layer (Diffusion)**
- Uses a **key-based permutation** to shuffle encrypted data.
- Completely hides plaintext structure.
- Prevents pattern recognition and statistical attacks.

### 🔹 **Encryption Process (Steps)**
1. Convert plaintext into a **16-byte block**.
2. Apply **Substitution (S-Box Transformation)**.
3. Apply **Transposition (Key-Based Shuffling)**.
4. Repeat for **10 rounds** for added security.
5. Return the final **ciphertext**.

### 🔹 **Decryption Process**
- Reverse the transposition step.
- Apply the inverse of the S-Box.
- Repeat for 10 rounds to retrieve the original plaintext.

---

## Why Is It Secure?
| Feature | **Substitution Only** | **Transposition Only** | **Hybrid Cipher** |
|---------|----------------------|----------------------|------------------|
| **Confusion (Hides Patterns)** | ✅ Yes | ❌ No | ✅ Yes |
| **Diffusion (Spreads Data)** | ❌ No | ✅ Yes | ✅ Yes |
| **Resistant to Frequency Analysis** | ✅ Yes | ❌ No | ✅ Yes |
| **Prevents Pattern Recognition** | ❌ No | ✅ Yes | ✅ Yes |
| **Brute-Force Secure (128-bit)** | ❌ No | ❌ No | ✅ Yes |

This hybrid approach ensures **higher security** than using substitution or transposition alone.

---

## Installation & Usage
### **1️⃣ Requirements**
- Java Development Kit (JDK 8 or later)

### **2️⃣ Compilation**
```sh
javac HybridCipher.java
```

### **3️⃣ Running the Cipher**
```sh
java HybridCipher
```
- Enter the message to encrypt.
- The program will return the **encrypted text** and **decrypted output**.

### **4️⃣ Run Online**
Click the link below to run the cipher online:  
👉 **[Run Hybrid Cipher](YOUR_LINK_HERE)**

---

## Tech Stack
- **Programming Language**: Java
- **Encryption Techniques**: AES-like S-Box, Key-based Transposition

---



