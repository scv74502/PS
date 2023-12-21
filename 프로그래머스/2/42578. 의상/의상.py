"""
백트래킹은 시간초과 발생, 점화식 이용하여 해결할 수 있음
A:a, B:b, C:c, ... D:d, E:e .. 개라고 가정한다
그러면 A종류만 있으면 (a+1)-1 = a개,
A, B 종류 있으면 a + b + ab = (a+1)(b+1) - 1 개
A, B, C 있으면 a + b + c+ ab + bc + ca + abc = (a + 1)(b + 1)(c + 1) - 1 개이다
즉 A, B, C, D, ... Z개 있으면, (a+1)(b+1)(c+1)(d+1) .... (z+1)
"""


def solution(clothes):
    answer = 1
    cdict = dict()
    for cloth in clothes:
        if cloth[1] not in cdict:
            cdict[cloth[1]] = set()
        cdict[cloth[1]].add(cloth[0])

    csize = [len(cdict[c]) for c in cdict]
    for num in csize:
        answer *= (num+1)

    return answer-1
