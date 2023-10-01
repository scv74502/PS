"""
체스판 나이트 움직임을 통해 bfs 구현해 보기
"""
from collections import deque
import sys


sin = sys.stdin.readline
N, M = map(int, sin().split())
maze = [list(map(int, sin().strip())) for _ in range(N)]
value = [[0 for __ in range(M)] for _ in range(N)]

# 상 하 좌 우
mov_m = [1, -1, 0, 0]
mov_n = [0, 0, -1, 1]

dq = deque()
dq.append([0, 0, 1])
value[0][0] = 1

while dq:
    cn, cm, cl = dq.popleft()
    if cn == N-1 and cm == M-1:
        print(cl)
        break

    for m in range(4):
        nn, nm = cn + mov_m[m], cm + mov_n[m]
        if 0 <= nn < N and 0 <= nm < M and maze[nn][nm]==1:
            if value[nn][nm] == 0 or value[nn][nm] > cl+1:
                value[nn][nm] = cl+1
                dq.append([nn, nm, cl+1])
