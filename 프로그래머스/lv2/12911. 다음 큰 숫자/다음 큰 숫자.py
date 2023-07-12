def solution(n):
    tgt = n + 1
    while True:
        if format(n, 'b').count('1') ==  format(tgt, 'b').count('1'):
            break
        else:
            tgt += 1
    return tgt
    
    answer = 0
    return answer 