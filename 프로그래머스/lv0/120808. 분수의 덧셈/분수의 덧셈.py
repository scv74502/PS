"""
1. 유클리드 호제법 이용한 최대공약수 찾기 숙지하기
"""


def Euclidean(a, b):
    while b != 0:
        [a, b] = [b, a%b]
    return a


def solution(numer1, denom1, numer2, denom2):
    answer = []
    if max(denom1, denom2) % min(denom1, denom2) == 0:
        mult = max(denom1, denom2) / min(denom1, denom2)
        if max(denom1, denom2) == denom1:
            answer.append(numer2 * mult + numer1)
            answer.append(denom1)
        else:
            answer.append(numer1 * mult + numer2)
            answer.append(denom2)
            
    else:
        answer.append(numer1 * denom2 + numer2 * denom1)
        answer.append(denom1 * denom2)
    
    div = Euclidean(answer[0], answer[1])
    answer = [answer[0] / div, answer[1]/ div]
    
    return answer