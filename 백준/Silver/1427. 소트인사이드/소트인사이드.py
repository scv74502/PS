import sys

sin = sys.stdin.readline
num = int(sin().strip())
digit = 0
nums = []

while num > 0:
    nums.append(num % 10)
    digit += 1
    num = num // 10


ans = 0
nums.sort(reverse=False)

for i in range(1, digit + 1):
    ans += (10 ** (i - 1)) * nums[i-1]

print(ans)