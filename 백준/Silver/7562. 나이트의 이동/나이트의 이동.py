"""
체스판 나이트 움직임을 통해 bfs 구현해 보기
"""
from collections import deque
import sys


sin = sys.stdin.readline
tc = int(sin())
# 상좌, 상우, 우상, 우하, 하우, 하좌, 좌하, 좌상
mx = [-1, 1, 2, 2, 1, -1, -2, -2]
my = [2, 2, 1, -1, -2, -2, -1, 1]

for _ in range(tc):
    l = int(sin())
    board = [[0 for __ in range(l)] for _ in range(l)]
    sx, sy = map(int, sin().split())
    dex, dey = map(int, sin().split())

    dq = deque()
    dq.append([sx, sy, 0])

    while dq:
        cx, cy, ct = dq.popleft()
        if cx == dex and cy == dey:
            print(ct)
            break

        for i in range(8):
            nx, ny = cx + mx[i], cy + my[i]

            if 0 <= nx < l and 0 <= ny < l:
                if board[ny][nx] == 0 or board[ny][nx] > ct+1:
                    board[ny][nx] = ct + 1
                    dq.append([nx, ny, ct+1])


