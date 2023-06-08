from math import floor, ceil, pow, sqrt

def solution(r1, r2):
    answer = 0
    
    for i in range(1, r2+1):
        maxY = floor(sqrt(pow(r2, 2) - pow(i, 2)))
        minY = ceil(sqrt(pow(r1, 2) - pow(i, 2))) if r1 > i else 0
        answer += maxY - minY + 1
    
    
    return answer * 4
