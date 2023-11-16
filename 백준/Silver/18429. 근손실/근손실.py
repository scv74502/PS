import sys


si = sys.stdin.readline
N, K = map(int, si().split(" "))
weights = list(map(int, si().split(" ")))
used = [False for _ in range(N)]
res = []
tri_sum = 500
routines = set()


def bt(idx):
    global tri_sum
    if len(res) == N:
        # ans = tuple(res)
        if tuple(res) not in routines:
            routines.add(tuple(res))
            return

    for i in range(0, N):
        if not used[i] and tri_sum + weights[i] - K >= 500:
            tri_sum += weights[i] - K
            res.append(i+1)
            used[i] = True
            bt(i)
            tri_sum -= weights[i] - K
            res.pop()
            used[i] = False


bt(0)
print(len(routines))