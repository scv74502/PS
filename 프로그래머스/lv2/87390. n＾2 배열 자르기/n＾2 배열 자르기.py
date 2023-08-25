def solution(n, left, right):
    # arr = [0 for j in range(n) for i in range(n)]
    tgt = [i+1 for i in range(left, right+1)]
    answer = []
    
    for num in tgt:
        div = num // n + 1
        left = num % n
        
        if div == 1:
            answer.append(num)
        elif left == 0:
            answer.append(n)
        elif left <= div:
            answer.append(div)
        else:
            answer.append(left)
            
    
    # print(answer)
    return answer
    
