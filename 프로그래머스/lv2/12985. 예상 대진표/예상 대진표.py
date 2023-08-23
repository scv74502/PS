def solution(n,a,b):
    answer = 0

    while n > 1:
        # print(n, a, b)
        answer += 1
        for i in range(0, n, 2):    
            #print(i)
            p1, p2 = i+1, i+2
            if (p1 == a and p2 == b) or (p1 == b and p2 == a):
                return answer
            elif p1 == a or p2 == a:
                a = i//2 +1
            elif p1 == b or p2 == b:
                b = i//2 +1
        n = n // 2
                
                
        

    return answer