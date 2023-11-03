import sys
from collections import deque


si = sys.stdin.readline
N = int(si())
grids = [list(si().strip()) for _ in range(N)]
visited = [[False for _ in range(N)] for __ in range(N)]
cw_visited = [[False for _ in range(N)] for __ in range(N)]
cnt, cw_cnt = 0, 0
# dq, cw_dq = deque(), deque()
# dq.append([0, 0])
# cnt += 1

# 상 하 좌 우
dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]


def bfs(x: int, y: int):
    global cnt
    cnt += 1
    dq = deque()
    dq.append([x, y])
    visited[y][x] = True
    sg = grids[y][x]

    while dq:
        cx, cy = dq.popleft()

        for m in range(4):
            nx, ny = cx + dx[m], cy + dy[m]

            if 0 <= nx < N and 0 <= ny < N and not visited[ny][nx] and sg == grids[ny][nx]:
                dq.append([nx, ny])
                visited[ny][nx] = True


def cw_bfs(x: int, y: int):
    global cw_cnt
    cw_cnt += 1
    dq = deque()
    dq.append([x, y])
    cw_visited[y][x] = True
    sg = grids[y][x]


    while dq:
        cx, cy = dq.popleft()

        for m in range(4):
            nx, ny = cx + dx[m], cy + dy[m]

            if 0 <= nx < N and 0 <= ny < N and not cw_visited[ny][nx]:
                if sg == grids[ny][nx]:
                    dq.append([nx, ny])
                    cw_visited[ny][nx] = True
                elif sg == "R" and grids[ny][nx] == "G":
                    dq.append([nx, ny])
                    cw_visited[ny][nx] = True
                elif sg == "G" and grids[ny][nx] == "R":
                    dq.append([nx, ny])
                    cw_visited[ny][nx] = True


for yy in range(N):
    for xx in range(N):
        if not visited[yy][xx]:
            # print(xx, yy)
            bfs(xx, yy)
            # print(visited)
        if not cw_visited[yy][xx]:
            # print(xx, yy)
            cw_bfs(xx, yy)
            # print(cw_visited)


print(cnt, cw_cnt)