# 🔐 Feistel Cipher in Python  

## 📜 Description  
This Python program implements a **Feistel cipher**, a symmetric encryption algorithm used in many cryptographic systems. The program encrypts text using **4 rounds** of Feistel transformations and then decrypts it back to its original form.  

## ✨ Features  
✅ Uses a **4-round Feistel structure** for encryption and decryption.  
✅ Generates **random 8-bit keys** for each round.  
✅ Supports **text input of any length** (pads odd-length input).  
✅ Ensures **reversible encryption** (decrypted text matches the original).  

## ⚙️ How It Works  
1. The program generates **4 random keys** (one for each round).  
2. The user enters a **plaintext message**.  
3. The text is converted into **ASCII values**, grouped into **pairs**.  
4. **Encryption:**  
   - Each pair undergoes **4 Feistel rounds** using XOR and swapping.  
5. **Decryption:**  
   - The process is reversed using the same keys in reverse order.  
6. The decrypted text is **converted back to readable form**.  

## 🛠 Code Explanation  
🔑 **Key Generation:** Generates 4 random 8-bit keys.  
📜 **Text Processing:** Converts input to ASCII and splits into pairs.  
🔄 **Feistel Rounds:** Each pair undergoes **XOR-based transformations** for encryption and decryption.  
🔓 **Decryption:** Uses the **same keys in reverse order** to recover the original text.  

## 🎯 Example Run  
**Input:**  
```bash
Enter text to encrypt: hello
```
**Output:**  
```bash
Original text:  hello
Encrypted pairs:  [(encrypted values)]
Decrypted text:  hello
```

## 🖥 Requirements  
🐍 **Python 3.x** installed.  
📝 A text editor or an IDE like **VS Code, PyCharm, or Jupyter Notebook**.  

## ⚠️ Notes  
⚡ The **encryption is reversible**, ensuring **data integrity**.  
⚡ **Keys are randomly generated**, so encryption output varies each time.  
⚡ If the input has an **odd length**, it is **padded with 0** for processing.  
