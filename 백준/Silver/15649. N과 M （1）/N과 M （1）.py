import sys


input = sys.stdin.readline
N, M = map(int, input().split())

res = []
chk = [False] * (N + 1)

def recur(num):
    if num == M:
        print(' '.join(map(str, res)))
        return
    for i in range(1, N+1):
        if chk[i] == False:
            chk[i] = True
            res.append(i)
            recur(num+1)
            chk[i] = False
            res.pop()

recur(0)