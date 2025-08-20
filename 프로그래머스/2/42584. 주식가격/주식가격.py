def solution(prices):
    # 1 2 3 2 3
    # [0, 1, 2, 3, 2, 3]
    n = len(prices)
    answer = [0 for _ in range(n)]
    stack = [0]
    
    for i in range(1, n):
        price = prices[i]
        while stack and price < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)
    
    while stack:
        j = stack.pop()
        answer[j] = n - 1 - j
        
    return answer