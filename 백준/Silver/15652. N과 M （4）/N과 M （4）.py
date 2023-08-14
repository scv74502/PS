import sys


input = sys.stdin.readline
N, M = map(int, input().split())

res = []

def recur(num):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return

    for i in range(1, N+1):
        if res:
            if res[-1] > i:
                continue
            else:
                res.append(i)
                recur(i + 1)
                res.pop()
        else:
            res.append(i)
            recur(i + 1)
            res.pop()

recur(1)