import sys
from collections import deque

sin = sys.stdin.readline
N, M, K = map(int, sin().split())
maze = [list(map(int, sin().strip())) for _ in range(N)]
visited = [[[0 for ___ in range(K + 1)] for __ in range(M)] for _ in range(N)]
mn = [-1, 1, 0, 0]
mm = [0, 0, -1, 1]


def bfs(sn: int, sm: int):
    dq = deque()
    dq.append([sn, sm, 0])
    visited[sn][sm][0] = 1

    while dq:
        # curM, curN, curRecord, curCrushed
        cn, cm, cc = dq.popleft()
        if cn == N - 1 and cm == M - 1:
            return visited[N - 1][M - 1][cc]

        for m in range(4):
            nn, nm = cn + mn[m], cm + mm[m]

            if 0 <= nm < M and 0 <= nn < N:
                # print(nn, nm)
                # 벽 부수지 않는 경우
                if maze[nn][nm] == 0 and visited[nn][nm][cc] == 0:
                    visited[nn][nm][cc] = visited[cn][cm][cc] + 1
                    dq.append([nn, nm, cc])

                # 벽 부수는 경우
                elif maze[nn][nm] == 1 and cc < K and visited[nn][nm][cc + 1] == 0:
                    # print(cc)
                    visited[nn][nm][cc + 1] = visited[cn][cm][cc] + 1
                    dq.append([nn, nm, cc + 1])

    else:
        return -1


ans = bfs(0, 0)
print(ans)
