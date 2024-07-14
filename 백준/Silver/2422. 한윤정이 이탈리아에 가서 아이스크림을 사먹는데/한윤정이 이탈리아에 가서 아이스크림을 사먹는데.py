import sys

sys.setrecursionlimit(10 ** 6)
N, M = map(int, sys.stdin.readline().split())
ice_creams = [i for i in range(1, N + 1)]
avoid_comb = [[False for _ in range(N+1)] for i in range(N + 1)]
answer = 0

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    avoid_comb[a][b] = True
    avoid_comb[b][a] = True


cur = set()
temp = []

for i in range(1, N+1):
    for j in range(i+1, N+1):
        if avoid_comb[i][j]:
            continue
        for k in range(j+1, N+1):
            if avoid_comb[k][j] or avoid_comb[i][k]:
                continue

            answer += 1

print(answer)
