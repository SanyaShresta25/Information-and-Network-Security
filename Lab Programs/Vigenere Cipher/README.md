
# 🔐 Vigenère Cipher in Python  

## 📜 Description  
This Python program implements the **Vigenère Cipher**, a polyalphabetic substitution encryption technique. It allows users to **encrypt and decrypt messages** using a keyword-based shifting pattern.  

## ✨ Features  
✅ **Encrypts text** using a keystream-based shift.  
✅ **Decrypts encrypted text** back to its original form.  
✅ Preserves **lowercase letters**, removing spaces for encryption.  
✅ Uses **modular arithmetic** for cyclic shifting of letters.  

## ⚙️ How It Works  
1. The user enters a **keystream** (keyword).  
2. The user enters a **message** to encrypt.  
3. Each letter in the message is **shifted** based on the corresponding letter in the keystream.  
4. **Decryption** reverses the shifting process to retrieve the original text.  

## 🛠 Code Explanation  
🔢 **vignere(key, message):** Encrypts the message by shifting letters based on keystream values.  
🔓 **decrypt_vignere(key, ciphertext):** Decrypts the message by reversing shifts.  
📜 **Key Processing:** Converts keystream letters into numeric shift values.  

## 🎯 Example Run  
**Input:**  
```bash
Enter the keystream: lemon
Enter the message: attack at dawn
```
**Output:**  
```bash
Encrypted Text: lxfopvefrnhr
Decrypted Text: attackatdawn
```

## 🖥 Requirements  
🐍 **Python 3.x** installed.  
📝 A text editor or an IDE like **VS Code, PyCharm, or Jupyter Notebook**.  

## 🚀 Link to Run  
🔹 Run the program online: [Click Here](https://www.onlinegdb.com/)  

## ⚠️ Notes  
⚡ Only **lowercase letters** are considered; spaces are removed.  
⚡ The **keystream should be a string of letters** (no numbers or special characters).  
⚡ The **decryption process correctly reverses the encryption** using modular arithmetic.  

