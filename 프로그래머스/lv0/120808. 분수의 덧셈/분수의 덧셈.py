"""
1. 유클리드 호제법 이용한 최대공약수 찾기 숙지하기
2. import math 이용하여 math 모듈의 gcd 함수 사용하기
"""
import math


def Euclidean(a, b):
    while b != 0:
        [a, b] = [b, a%b]
    return a


def solution(numer1, denom1, numer2, denom2):
    numer = numer1 * denom2 + numer2 * denom1
    denom = denom1 * denom2
    
    gcd = math.gcd(numer, denom)
    
    return [numer / gcd, denom / gcd]