import sys


input = sys.stdin.readline
N, M = map(int, input().split())

res = []

def recur(num):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return

    for i in range(num, N+1):
        if i not in res:
            res.append(i)
            recur(i + 1)
            res.pop()

recur(1)