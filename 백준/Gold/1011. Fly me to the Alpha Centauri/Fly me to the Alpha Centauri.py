import sys
import math

def jumpnum(a, b):
    dist = b - a
    answer = 0
    if dist == 1:
        answer = 1
    elif dist == 2:
        answer = 2
    else:
        lower = math.floor(math.sqrt(dist))**2 ## 자신 기준 아래의 제곱수
        upper = math.ceil(math.sqrt(dist))**2 ## 자신 기준 위의 제곱수

        if dist - lower < upper - dist: ## 아래의 제곱수와 더 가깝다면
            answer = math.sqrt(lower)*2
        else:
            answer = math.sqrt(upper)*2 - 1
    return answer

n = int(sys.stdin.readline())

for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    print(int(jumpnum(a, b)))








