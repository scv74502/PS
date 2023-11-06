import sys


si = sys.stdin.readline
T = int(si())

for _ in range(T):
    N = int(si())
    nums = list(map(int, si().strip().split(" ")))
    print(min(nums), max(nums))