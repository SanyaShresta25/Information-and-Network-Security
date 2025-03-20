def vignere(key, message):
    message = message.lower().replace(' ', '')
    m = len(key)
    cipherText = ""
    
    for i in range(len(message)):
        letter = message[i]
        k = key[i % m]
        cipherText += chr((ord(letter) + k - 97) % 26 + 97)
    
    return cipherText


def decrypt_vignere(key, cipherText):
    key = [-1 * k for k in key]
    return vignere(key, cipherText)


# Input from user
key = input("Enter the keystream: ")
message = input("Enter the message: ")

# Convert key to corresponding shift values
key = [ord(letter) - 97 for letter in key]

# Encryption
ciphertext = vignere(key, message)
print("Encrypted Text:", ciphertext)

# Decryption
plaintext = decrypt_vignere(key, ciphertext)
print("Decrypted Text:", plaintext)
