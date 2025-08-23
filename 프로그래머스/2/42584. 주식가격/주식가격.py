def solution(prices):
    N = len(prices)
    answer = [0 for _ in range(len(prices))]
    stack = [0]
    
    for i in range(1, len(prices)):
        price = prices[i]
        
        if price >= prices[stack[-1]]:
            stack.append(i)
            continue
        
        # print(price, stack[-1])
        while stack and price < prices[stack[-1]]:
            idx = stack.pop()
            answer[idx] = i - idx
        
        stack.append(i)
        
        # print(i, ":", stack)
        # print(i, ":", answer)
    
    # print("out:", stack)
    # print("out:", answer)
    
    while stack:
        idx = stack.pop()
        answer[idx] = N - idx - 1
    
    return answer