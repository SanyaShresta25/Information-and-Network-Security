import os
import tkinter as tk
from tkinter import messagebox, scrolledtext, simpledialog
import cryptography.hazmat.primitives.asymmetric.rsa as rsa
import cryptography.hazmat.primitives.asymmetric.dh as dh
import cryptography.hazmat.primitives.hashes as hashes
import cryptography.hazmat.primitives.kdf.pbkdf2 as pbkdf2
import cryptography.hazmat.primitives.serialization as serialization
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

# Key Generation
def generate_symmetric_key():
    return os.urandom(32)  # AES-256 key

def generate_asymmetric_keys():
    private_key = rsa.generate_private_key(public_exponent=65537, key_size=2048, backend=default_backend())
    public_key = private_key.public_key()
    return private_key, public_key

def generate_dh_parameters():
    return dh.generate_parameters(generator=2, key_size=2048, backend=default_backend())

def generate_dh_keys(parameters):
    private_key = parameters.generate_private_key()
    public_key = private_key.public_key()
    return private_key, public_key

def compute_dh_shared_key(private_key, peer_public_key):
    shared_key = private_key.exchange(peer_public_key)
    derived_key = pbkdf2.PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=os.urandom(16),
        iterations=100000,
        backend=default_backend()
    ).derive(shared_key)
    return derived_key

# Key Storage (Encrypt and Save Keys)
def save_key_to_file(key, filename):
    with open(filename, 'wb') as f:
        f.write(key)

def load_key_from_file(filename):
    if os.path.exists(filename):
        with open(filename, 'rb') as f:
            return f.read()
    else:
        return None

def revoke_key(filename):
    if os.path.exists(filename):
        os.remove(filename)
        log_action(f"Key {filename} revoked.")
        messagebox.showinfo("Revocation", f"Key {filename} revoked.")
    else:
        messagebox.showwarning("Warning", "Key does not exist.")

# Encryption and Decryption (AES)
def encrypt_with_aes():
    key = load_key_from_file("aes_key.bin")
    if not key:
        messagebox.showwarning("Warning", "AES key not found. Generate it first.")
        return
    
    plaintext = simpledialog.askstring("Encryption", "Enter text to encrypt:")
    if not plaintext:
        messagebox.showwarning("Warning", "No text entered for encryption.")
        return
    
    iv = os.urandom(16)
    cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())
    encryptor = cipher.encryptor()
    padded_plaintext = plaintext.ljust(16 * ((len(plaintext) // 16) + 1), '\0')
    ciphertext = encryptor.update(padded_plaintext.encode()) + encryptor.finalize()
    
    save_key_to_file(iv + ciphertext, "encrypted_data.bin")
    log_action("Data encrypted and saved.")
    messagebox.showinfo("Encryption", "Data encrypted and saved.")

def decrypt_with_aes():
    key = load_key_from_file("aes_key.bin")
    encrypted_data = load_key_from_file("encrypted_data.bin")
    
    if not key or not encrypted_data:
        messagebox.showwarning("Warning", "AES key or encrypted data not found.")
        return
    
    iv, ciphertext = encrypted_data[:16], encrypted_data[16:]
    cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())
    decryptor = cipher.decryptor()
    decrypted_text = decryptor.update(ciphertext) + decryptor.finalize()
    decrypted_text = decrypted_text.decode().rstrip('\0')
    
    log_action(f"Decrypted Text: {decrypted_text}")
    messagebox.showinfo("Decryption", f"Decrypted Text: {decrypted_text}")

# GUI Application
def generate_keys():
    aes_key = generate_symmetric_key()
    save_key_to_file(aes_key, "aes_key.bin")
    
    private_rsa, public_rsa = generate_asymmetric_keys()
    save_key_to_file(private_rsa.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.TraditionalOpenSSL,
        encryption_algorithm=serialization.NoEncryption()
    ), "private_rsa.pem")

    save_key_to_file(public_rsa.public_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
    ), "public_rsa.pem")

    log_action("Keys generated and saved.")
    messagebox.showinfo("Success", "Keys generated and saved.")

def perform_key_exchange():
    dh_params = generate_dh_parameters()
    private_dh, public_dh = generate_dh_keys(dh_params)
    peer_private_dh, peer_public_dh = generate_dh_keys(dh_params)
    shared_key = compute_dh_shared_key(private_dh, peer_public_dh)
    log_action(f"Shared Key: {shared_key.hex()}")
    messagebox.showinfo("Key Exchange", f"Shared Key: {shared_key.hex()}")

def revoke_aes_key():
    if os.path.exists("aes_key.bin"):
        revoke_key("aes_key.bin")
    else:
        messagebox.showwarning("Warning", "AES key file does not exist before revocation.")

def view_rsa_keys():
    private_key = load_key_from_file("private_rsa.pem")
    public_key = load_key_from_file("public_rsa.pem")
    
    if private_key and public_key:
        log_action("Displaying stored RSA keys.")
        messagebox.showinfo("Stored Keys", f"Private Key:\n{private_key.decode()}\n\nPublic Key:\n{public_key.decode()}")
    else:
        messagebox.showwarning("Warning", "Keys not found.")

def log_action(action):
    log_text.insert(tk.END, action + "\n")
    log_text.yview(tk.END)

# Create GUI window
root = tk.Tk()
root.title("Secure Key Management System")
root.geometry("600x700")  # Adjust window size
root.configure(bg="#FFC0CB")

# Center the window
window_width = 600
window_height = 700
screen_width = root.winfo_screenwidth()
screen_height = root.winfo_screenheight()
position_top = int(screen_height / 2 - window_height / 2)
position_right = int(screen_width / 2 - window_width / 2)
root.geometry(f'{window_width}x{window_height}+{position_right}+{position_top}')

# Info and Title Labels
info_label = tk.Label(root, text="Information and Network Security", font=("Arial", 12, "bold"), bg="#FFC0CB")
info_label.grid(row=0, column=0, columnspan=2, pady=5)

title_label = tk.Label(root, text="Secure Key Management System", font=("Arial", 14, "bold"), bg="#FFC0CB")
title_label.grid(row=1, column=0, columnspan=2, pady=5)

# Button definitions with grid layout and sky blue borders
button_font = ("Arial", 10, "bold")
button_style = {
    "relief": "solid",           # Solid border
    "bd": 4,                     # Border thickness
    "fg": "black",               # Text color
    "bg": "#ffffff",             # Background color (optional)
    "highlightbackground": "#4682B4",  # Border color when not focused (blue)
    "highlightthickness": 2,     # Thickness of the highlight border
}

# Adjusting padding and removing large gaps between buttons
tk.Button(root, text="Generate Keys", command=generate_keys, font=button_font, **button_style).grid(row=2, column=0, padx=3, pady=1, sticky="ew")
tk.Button(root, text="Encrypt with AES", command=encrypt_with_aes, font=button_font, **button_style).grid(row=2, column=1, padx=3, pady=1, sticky="ew")
tk.Button(root, text="Decrypt with AES", command=decrypt_with_aes, font=button_font, **button_style).grid(row=3, column=0, padx=3, pady=1, sticky="ew")
tk.Button(root, text="Key Exchange", command=perform_key_exchange, font=button_font, **button_style).grid(row=3, column=1, padx=3, pady=1, sticky="ew")
tk.Button(root, text="Revoke AES Key", command=revoke_aes_key, font=button_font, **button_style).grid(row=4, column=0, padx=3, pady=1, sticky="ew")
tk.Button(root, text="View RSA Keys", command=view_rsa_keys, font=button_font, **button_style).grid(row=4, column=1, padx=3, pady=1, sticky="ew")

# Log Textbox
log_text = scrolledtext.ScrolledText(root, width=50, height=10, font=("Arial", 10))
log_text.grid(row=5, column=0, columnspan=2, pady=9)

# Configure grid to make it responsive
root.grid_rowconfigure(0, weight=1)
root.grid_rowconfigure(1, weight=1)
root.grid_rowconfigure(2, weight=1)
root.grid_rowconfigure(3, weight=1)
root.grid_rowconfigure(4, weight=1)
root.grid_rowconfigure(5, weight=3)
root.grid_columnconfigure(0, weight=1)
root.grid_columnconfigure(1, weight=1)

root.mainloop()

