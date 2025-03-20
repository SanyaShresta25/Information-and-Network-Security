# Function to find GCD
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# RSA Encryption and Decryption
def RSA(p, q, msg):
    # Step 1: Calculate n and φ(n)
    n = p * q
    phi = (p - 1) * (q - 1)

    # Step 2: Choose Public Key 'e' (1 < e < phi and gcd(e, phi) = 1)
    for e in range(2, phi):
        if gcd(e, phi) == 1:
            break

    # Step 3: Calculate Private Key 'd' (d * e ≡ 1 mod φ(n))
    d = 0
    for i in range(1, phi):
        if (i * e) % phi == 1:
            d = i
            break

    # Step 4: Encryption (C = M^e mod n)
    c = pow(msg, e, n)

    # Step 5: Decryption (M = C^d mod n)
    m = pow(c, d, n)

    # Output
    print("Public Key (e, n):", (e, n))
    print("Private Key (d, n):", (d, n))
    print("Encrypted Message:", c)
    print("Decrypted Message:", m)


# Input from user
p = int(input("Enter prime number p: "))
q = int(input("Enter prime number q: "))
msg = int(input("Enter a message (in number format): "))

RSA(p, q, msg)
