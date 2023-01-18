import sys

input = sys.stdin.readline

n = int(input())

dp = [[0]*21 for _ in range(0, n)]
# print(len(dp))
# for i in range(0, n):
    # for j in range(0, 21):
        # print(dp[i][j])

num_list = list(map(int, input().split(" ")))
# print(num_list)
dp[0][num_list[0]] = 1

for i in range(1, n-1):
    for j in range(0, 21):
        if dp[i-1][j] != 0:
            plus = j + num_list[i]
            minus = j - num_list[i]
            if 0 <= plus <= 20:
                dp[i][plus] += dp[i-1][j]
            if 0 <= minus <= 20:
                dp[i][minus] += dp[i-1][j]
        # dp[i][j] += dp[i-1][j]

# print(dp)
# print("-------------------------------------------------------------------------------")
print(dp[n-2][num_list[-1]])