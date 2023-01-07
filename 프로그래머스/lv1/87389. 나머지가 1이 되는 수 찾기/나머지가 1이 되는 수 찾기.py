def solution(n):
    temp = 0
    for i in range(n, 0, -1):
        if n % i == 1:
            temp = i
            break
    #print(temp)
    answer = 0
    for i in range(2, temp+1):
        if temp % i == 0:
            answer = i
            break;
            
    #print(answer)
    return answer