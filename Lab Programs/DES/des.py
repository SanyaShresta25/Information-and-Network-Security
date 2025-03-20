import random

# Convert text to binary
s = input("Enter a string: ")
result = ''.join(format(ord(i), '08b') for i in s)
answer = "".join(result[i] for i in range(len(result)) if i % 8 != 0)

# Divide into Left and Right halves
l = len(answer) // 2
left, right = answer[:l], answer[l:]

# Left Circular Shift Table (lt)
lt = [2, 1, 4, 3, 6, 5, 7, 8]

# Generate 8 subkeys
keys = []
for i in range(8):
    # Left Circular Shift
    nl = bin(int(left, 2) << lt[i])
    nr = bin(int(right, 2) << lt[i])
    
    # Combine left and right parts
    newKey = nr[2:] + nl[2:]

    # Random 8-bit key generation
    rm = random.sample(range(len(newKey)), 8)
    newAnswer = "".join(newKey[j] for j in rm)

    keys.append(newAnswer)

# Print all 8 keys
for i, key in enumerate(keys):
    print("Key", i+1, "=", key)
