def solution(prices):
    answer = [0 for _ in range(len(prices))]
    stack = []
    
    for i in range(len(prices) - 1):
        cur_price = prices[i]        
        for j in range(i, len(prices) - 1):
            if cur_price <= prices[j]:
                stack.append(prices[j])
            else:
                break
            
        # print(stack)
        answer[i] = len(stack)
        
        stack = []
    
    return answer