import sys


input = sys.stdin.readline
n, m = map(int, input().split())

stage = [list(map(int, input().split())) for _ in range(n)]
r_group = [sum(stage[j][i] for j in range(n)) for i in range(m)]

A = int(input())
cur = sum(r_group[:A])
mval = cur
for i in range(A, m):
    cur += (r_group[i] - r_group[i-A])
    if cur > mval:
        mval = cur

print(mval)

