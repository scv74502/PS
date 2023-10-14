import sys


sin = sys.stdin.readline
N = int(sin())

res = []
def solution(res):
    if len(res) == N:
        print(" ".join(map(str, res)))

    for i in range(1, N+1):
        if i not in res:
            res.append(i)
            solution(res)
            res.pop()

solution(res)