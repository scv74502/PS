import sys

input = sys.stdin.readline
n = int(input())
wine = [int(input()) for _ in range(n)]
dp = [0 for _ in range(n+1)]

dp[0] = 0
dp[1] = wine[0]

if n <= 1:
    answer = dp[1]
else:
    dp[2] = wine[0] + wine[1]
    if n <= 2:
        answer = dp[2]
    else:
        for i in range(3, n+1):
            dp[i] = dp[i-3] + wine[i-2] + wine[i-1] # 2번째 잔과 3번째 잔 마심
            dp[i] = max(dp[i-2] + wine[i-1], dp[i-1], dp[i]) # 1-3잔, 1-2잔, 2-3잔 비교하기
        answer = dp[n]

print(answer)
