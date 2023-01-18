import sys

def solution(k, n):
    f0 = [int(x) for x in range(1, n+1)]
    ans = 0
    for i in range(0, k):
        for j in range(1, n):
            f0[j] += f0[j-1]
    return f0[-1]

t = int(sys.stdin.readline())   # rpt

for _ in range(0, t):
    k = int(sys.stdin.readline())   # floor
    n = int(sys.stdin.readline())   # number
    print(solution(k, n))


