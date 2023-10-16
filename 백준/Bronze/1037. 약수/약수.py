import sys


sin = sys.stdin.readline
n = int(sin())
nums = list(map(int, sin().split()))

maxn, minn = max(nums), min(nums)

print(maxn * minn)
