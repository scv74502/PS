import sys
from collections import deque

si = sys.stdin.readline
tc = int(si())

# 상하좌우
dm = [1, -1, 0, 0]
dn = [0, 0, -1, 1]


for test in range(tc):
    M, N, K = map(int, si().split(" "))
    farm = [[0 for _ in range(N)] for __ in range(M)]
    visited = [[False for _ in range(N)] for __ in range(M)]

    for _ in range(K):
        gm, gn = map(int, si().split(" "))
        farm[gm][gn] = 1

    cnt = 0


    def bfs(sm, sn):
        global cnt
        cnt += 1

        dq = deque()
        dq.append([sm, sn])

        while dq:
            cm, cn = dq.popleft()

            for mv in range(4):
                nm, nn = cm + dm[mv], cn + dn[mv]
                if 0 <= nm < M and 0 <= nn < N and not visited[nm][nn] and farm[nm][nn] == 1:
                    visited[nm][nn] = True
                    dq.append([nm, nn])


    for i in range(M):
        for j in range(N):
            if not visited[i][j] and farm[i][j] == 1:
                visited[i][j] = True
                bfs(i, j)

    print(cnt)


