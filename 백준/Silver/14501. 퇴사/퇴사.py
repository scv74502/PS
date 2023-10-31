import sys

si = sys.stdin.readline
n = int(si())
tli = [0 for _ in range(n)]
pli = [0 for _ in range(n)]
dp = [0 for _ in range(n+1)]

for i in range(0, n):
    t, p = map(int, si().split(" "))
    tli[i], pli[i] = t, p

for i in range(n):
    for j in range(i+tli[i], n+1):
        if dp[j] < dp[i] + pli[i]:
            dp[j] = dp[i] + pli[i]

print(dp[-1])





