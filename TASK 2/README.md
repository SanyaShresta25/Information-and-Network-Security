# 🔐 Secure Key Management System

## Overview
Secure Key Management System is a Python-based tool designed to securely generate, store, and manage cryptographic keys. It provides both a **GUI-based version** for an interactive experience and a **command-line version** for direct usage in local environments.

## Features
- **Symmetric Key Management:** Secure AES-256 key generation, encryption, and decryption.
- **Asymmetric Key Management:** RSA key pair generation and storage.
- **Diffie-Hellman Key Exchange:** Secure shared key generation using DH parameters.
- **Key Revocation:** Ability to revoke and delete stored keys.
- **Logging System:** Tracks key operations and displays them in the GUI.
- **GUI Interface:** A user-friendly graphical interface for managing cryptographic keys.

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
   git clone <[repository-url](https://github.com/SanyaShresta25/Information-and-Network-Security>
   cd <repository-folder>
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

