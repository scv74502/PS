def solution(triangle):
    dep = len(triangle)
    dp = [[0 for _ in range(i)]for i in range(1, dep+1)]
    dp[0][0] = triangle[0][0]
    if dep == 1:
            return dp[0][0]
    else:
        for depth, tri in enumerate(triangle):
            if depth == dep-1:
                break
            else:
                for i in range(len(tri)):
                    dp[depth+1][i] = max(dp[depth+1][i], triangle[depth+1][i]+dp[depth][i])
                    dp[depth+1][i+1] = max(dp[depth+1][i+1], triangle[depth+1][i+1]+dp[depth][i])
    
                
    # print(dp)    
    return max(dp[-1])