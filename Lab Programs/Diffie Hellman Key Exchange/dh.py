import math
q = int(input("Enter a prime number : "))
a = int(input("Enter a primitive root :"))
Xa = int(input("Enter the private key of A :"))
Xb = int(input("Enter the private key of B : "))
Ya = math.pow(a, Xa) % q
Yb = math.pow(a, Xb) % q
print("Public key of A : ",Ya)
print("Public key of B : ",Yb)
Ka = math.pow(Yb,Xa)%q
Kb = math.pow(Ya,Xb)%q
print("Shared key for A : ",Ka)
print("Shared key for B : ",Kb)
