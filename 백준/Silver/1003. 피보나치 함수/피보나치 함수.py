import sys
"""
반복, 재귀 상관없이 피보나치를 그대로 사용하면 시간 혹은 메모리에서 초과된다
따라서 피보나치 수열의 점화식 특성을 이용하여 dp로 해결해야 한다
fib(n) = fib(n-1) + fib(n-2) 특성을 이용
"""


input = sys.stdin.readline
T = int(input().strip())

def fib(n):
    if n == 0:
        return 1, 0
    elif n == 1:
        return 0, 1
    else:
        dp = [[0, 0] for _ in range(n+1)]
        dp[0][0], dp[0][1], dp[1][0], dp[1][1] = 1, 0, 0, 1
        for i in range(2, n+1):
            dp[i][0], dp[i][1] = dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]
        return dp[n][0], dp[n][1]

for _ in range(T):
    num = int(input().strip())
    z_called, o_called = fib(num)
    print(z_called, o_called)











