# 🔐 Secure Key Management System

## Overview
Secure Key Management System is a Python-based tool designed to securely generate, store, and manage cryptographic keys. It provides both a **GUI-based version** for an interactive experience and a **command-line version** for direct usage in local environments.

## Features
# Key Distribution System

## Overview
This project implements a **Key Distribution System** that supports:
- **Centralized Key Distribution** for symmetric encryption.
- **Public Key Infrastructure (PKI)** for asymmetric encryption.
- **Secure Key Exchange** using the **Diffie-Hellman** algorithm.
- **Key Revocation** in case of compromise.

## Features
### 1. Centralized Key Distribution (Symmetric Encryption)
- **AES-256 Encryption** for secure data transmission.
- **Key Storage:** AES keys are securely stored in a file.
- **Encryption & Decryption:** Secure encryption and decryption using the stored key.

### 2. Public Key Infrastructure (PKI) (Asymmetric Encryption)
- **RSA Key Generation** (2048-bit).
- **Storage of Private & Public Keys** for secure encryption.
- **Ability to View RSA Keys** for verification.

### 3. Secure Key Exchange using Diffie-Hellman
- **Generation of DH Parameters** (Prime modulus & generator).
- **Exchange of Public Keys** between communicating parties.
- **Shared Key Derivation** using PBKDF2 for added security.

### 4. Key Revocation
- **Immediate Deletion of Keys** upon compromise.
- **AES Key Revocation** ensures sensitive data remains protected.
- **RSA Key Revocation** for compromised asymmetric keys.

## Security Measures
| **Threat** | **Mitigation in This System** |
|------------|------------------------------|
| **Man-in-the-Middle (MITM) Attack** | RSA encryption ensures public key integrity and prevents MITM. |
| **Key Compromise** | Key revocation functions allow immediate deletion and replacement. |
| **Brute Force Attack** | AES-256 and PBKDF2 key derivation ensure strong cryptographic security. |
| **Replay Attack** | Secure Diffie-Hellman prevents old key reuse. |
| **Unauthorized Access** | Private keys are securely stored, limiting access. |

## Installation & Usage
1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/key-distribution-system.git
   cd key-distribution-system
   ```
2. **Install Dependencies**
   ```bash
   pip install cryptography
   ```
3. **Run the Key Distribution System**
   ```bash
   python main.py
   ```

## Future Scope
- Implement **Role-Based Access Control (RBAC)** for key management.
- Integrate with a **Key Management Service (KMS)** for better security.
- Add **Digital Signatures** to authenticate Diffie-Hellman key exchange.
- Implement **Key Rotation Mechanism** to replace keys periodically.

## License
This project is licensed under the MIT License.

## Author
[Your Name] - [Your GitHub Profile]


## 🛠 Tech Stack
- **Python**: Core programming language.
- **Tkinter**: GUI framework for the graphical interface.
- **Cryptography Library**: Used for secure key encryption, decryption, and key exchange.
- **Google Colab**: Used for running the GUI-based version online.

## Running the Project

### 1. Running with GUI
#### Running the GUI Version 
1. Clone the repository:
   ```sh
   git clone https://github.com/SanyaShresta25/Information-and-Network-Security
   cd TASK 2
   ```
2. Install dependencies:
   ```sh
   pip install cryptography
   ```
3. Run the GUI application:
   ```sh
   python secureKeyWithGUI.py
   ```

### 2. Running with CLI
To run the command-line version, open the following link:
[SecureKeyMngmt CLI](https://colab.research.google.com/github/SanyaShresta25/Information-and-Network-Security/blob/main/TASK%202/SecureKeyMngmt.ipynb)

## Usage
- **Generate Keys:** Creates AES-256 and RSA key pairs, storing them securely.
- **Encrypt/Decrypt Data:** Uses AES encryption with CBC mode to secure text data.
- **Perform Key Exchange:** Generates Diffie-Hellman shared keys securely.
- **Revoke Keys:** Deletes stored keys and logs the action.
- **View RSA Keys:** Displays stored public and private RSA keys.

## 🚀 Why Use This Project?
- **Enhanced Security:** Uses industry-standard encryption techniques.
- **User-Friendly Interface:** Simple GUI for easy key management.
- **Comprehensive Key Lifecycle Management:** From generation to revocation.
- **Flexible Usage:** Supports both GUI-based and CLI-based interactions.

This project is built with security and usability in mind, making cryptographic key management simple yet powerful!

## 📧 Contact
For any inquiries or support, contact: **sanyashresta@gmail.com**

