import sys

num, lim = map(int, sys.stdin.readline().split())
things = []
dp = [[0 for lim in range(lim+1)] for num in range(num)]
for _ in range(num):
    w, v = map(int, sys.stdin.readline().split())
    things.append([w, v])

# print(dp)

#DP[i][j]=max((DP[i][j-해당차례 물건 무게]+해당차례 물건 가치),DP[i-1][j])
for i in range(0, num):
    weight, value = things[i][0], things[i][1]
    for j in range(0, lim+1):
        if(j < things[i][0]): dp[i][j] = dp[i-1][j]
        else: dp[i][j] = max(dp[i-1][j], dp[i-1][j - weight] + value)
print(dp[num-1][lim])