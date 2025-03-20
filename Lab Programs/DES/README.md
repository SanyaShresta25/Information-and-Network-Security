
# 🔐 DES Key Generation in Python  

## 📜 Description  
This Python program implements a **DES-like key generation technique**. It converts an input string into binary, applies bit manipulation, and generates **8 subkeys** using left circular shifts and random bit selection.  

## ✨ Features  
✅ Converts input text into an **8-bit binary representation**.  
✅ Removes **parity bits** (every 8th bit).  
✅ Splits the binary string into **left and right halves**.  
✅ Performs **left circular shifts** based on a predefined shift table.  
✅ Generates **8 random subkeys** from the transformed binary string.  

## ⚙️ How It Works  
1. The user provides a **plaintext string**.  
2. The program converts the string into **binary** and removes parity bits.  
3. The modified binary string is **split into left and right halves**.  
4. Each half undergoes **left circular shifts**.  
5. A **random selection of bits** is performed to create **8 unique subkeys**.  
6. The program displays the **generated DES subkeys**.  

## 🛠 Code Explanation  
🔢 **Binary Conversion**: Converts text into an 8-bit binary format.  
✂ **Bit Manipulation**: Removes parity bits (every 8th bit).  
🔀 **Splitting & Shifting**: Divides the binary string into two halves and applies **left circular shifts**.  
🔐 **Key Generation**: Combines the shifted halves and randomly selects **8-bit subkeys**.  

## 🎯 Example Run  
**Input:**  
```bash
Enter a string: SecureKey
```
**Output:**  
```bash
Key 1 = 10111010  
Key 2 = 11001101  
Key 3 = 01100111  
...  
Key 8 = 10010100  
```  

## 🖥 Requirements  
🐍 **Python 3.x** installed.  
📝 A text editor or an IDE like **VS Code, PyCharm, or Jupyter Notebook**.  

## 🚀 Link to Run  
Run the script on an online Python compiler:  
[Python Online Compiler](https://onlinegdb.com/_CcOhPgeC))  

## ⚠️ Notes  
⚡ This is a **DES key generation simulation**, not a full DES encryption/decryption implementation.  
⚡ The random selection process ensures **unique subkeys** each time the program runs.  
⚡ The **shift table** is predefined but can be modified for variations in key generation.  

