import sys


sin = sys.stdin.readline
num1, num2 = map(int, sin().split())


def gcd(a, b):
    if a < b:
        a, b = b, a
    while b != 0:
        a, b = b, a%b
    return a


gcv = gcd(num1, num2)

print(gcv)
print(num1 * num2 // gcv)
