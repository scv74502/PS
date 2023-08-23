def solution(n):
    dp = [0 for i in range(n)]
    if n < 2:
        return 1
    elif n < 3:
        return 2
    else:
        dp[0], dp[1] = 1, 2
        for i in range(2, n):
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567

        return dp[n-1]