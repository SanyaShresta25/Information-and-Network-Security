import random

# Generate random keys
num_rounds = 4
keys = [random.randint(0, 255) for _ in range(num_rounds)]

# Take user input
text = input("Enter text to encrypt: ")

# Convert text to ASCII pairs
text_bytes = [ord(c) for c in text]
if len(text_bytes) % 2 != 0:
    text_bytes.append(0)  # Pad with 0 if odd length
text_pairs = [(text_bytes[i], text_bytes[i + 1]) for i in range(0, len(text_bytes), 2)]

# Encrypt
encrypted_pairs = []
for left, right in text_pairs:
    for key in keys:
        left, right = right, left ^ (right ^ key)  # Feistel round
    encrypted_pairs.append((left, right))

# Decrypt
decrypted_pairs = []
for left, right in encrypted_pairs:
    for key in reversed(keys):
        left, right = right ^ (left ^ key), left  # Reverse Feistel round
    decrypted_pairs.append((left, right))

# Convert back to text
decrypted_text = "".join(chr(num) for pair in decrypted_pairs for num in pair if num != 0)

print("\nOriginal text: ", text)
print("Encrypted pairs: ", encrypted_pairs)
print("Decrypted text: ", decrypted_text)
