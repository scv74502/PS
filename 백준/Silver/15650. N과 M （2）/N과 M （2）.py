import sys


input = sys.stdin.readline
N, M = map(int, input().split())

res = []
# checked = [False] * (N+1)

def recur(num):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return

    for i in range(num, N+1):
        if i not in res:
            # checked[i] = True
            res.append(i)
            recur(i + 1)
            # checked[i] = False
            res.pop()


recur(1)