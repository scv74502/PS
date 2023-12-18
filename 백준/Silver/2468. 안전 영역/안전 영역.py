import sys
from collections import deque


# 상, 하, 좌, 우
mn = [-1, 1, 0, 0]
mm = [0, 0, -1, 1]


def bfs(area: list[list[int]], R: int) -> int:
    cnt = 0
    N = len(area)
    visited = [[False for __ in range(N)] for _ in range(N)]
    dq = deque()

    for i in range(N):
        for j in range(N):
            if not visited[i][j] and area[i][j] > R:
                cnt += 1
                dq.append([i, j])
                visited[i][j] = True

                while dq:
                    cn, cm = dq.popleft()

                    for mv in range(4):
                        nn, nm = cn + mn[mv], cm + mm[mv]

                        if 0 <= nn < N and 0 <= nm < N and not visited[nn][nm]:
                            visited[nn][nm] = True
                            if area[nn][nm] > R:
                                dq.append([nn, nm])

    return cnt


sin = sys.stdin.readline
N = int(sin())
area_ipt = [list(map(int, sin().split(" "))) for _ in range(N)]
max_val = max([max(row) for row in area_ipt])
res = 1

for i in range(1, max_val):
    res = max(res, bfs(area_ipt, i))

print(res)