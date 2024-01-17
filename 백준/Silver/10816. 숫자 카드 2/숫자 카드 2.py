import sys

sin = sys.stdin.readline
N = int(sin())
nums = list(map(int, sin().split()))
M = int(sin())
checks = list(map(int, sin().split()))

cntd = dict()
for num in nums:
    if num not in cntd:
        cntd[num] = 1
    else:
        cntd[num] += 1

for check in checks:
    if check in cntd:
        print(cntd[check], end=' ')
    else:
        print(0, end=' ')
