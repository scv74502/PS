import sys

sin = sys.stdin.readline
tc = int(sin())

dp = [0 for _ in range(11)]
dp[1], dp[2], dp[3] = 1, 2, 4 # 각자 자기 자신을 포함하여 1, 2, 3의 합으로 나타내는 가짓수

for i in range(4, 11):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

for _ in range(tc):
    N = int(sin())
    print(dp[N])