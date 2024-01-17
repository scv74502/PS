import sys

sin = sys.stdin.readline
N = int(sin())

ans = 0
digit = 0

while 10 ** digit <= N:
    digit += 1

ans += (N - (10 ** (digit - 1)) + 1) * digit
# print((N - (10 ** (digit - 1)) + 1) * digit)

while digit >= 2:
    # print((10 ** (digit - 1) - 1))
    # print(10 ** (digit - 2))
    # print(digit - 1)
    ans += ((10 ** (digit - 1)) - 10 ** (digit - 2)) * (digit - 1)
    digit -= 1

print(ans)