def solution(n):
    cnt = 1
    
    if n == 1:
        return 1
    elif n == 2:
        return 1
    else:
        while n > 1:
            if n % 2 == 0:
                n = n // 2
            else:
                n -= 1
                cnt += 1
    
    return cnt