import sys
from collections import deque

sin = sys.stdin.readline
n = int(sin())

maps = [list(map(int, sin().strip())) for _ in range(n)]
visited = [[False for i in range(n)] for _ in range(n)]
mc = [-1, 1, 0, 0]
mr = [0, 0, -1, 1]
answers = []


def bfs(i, j):
    dq = deque()
    dq.append([i, j])
    cnt = 0

    while dq:
        col, row = dq.pop()
        visited[col][row] = True
        cnt += 1

        for m in range(4):
            nc = col + mc[m]
            nr = row + mr[m]

            if 0 <= nc < n and 0 <= nr < n and visited[nc][nr] is False and maps[nc][nr] == 1:
                dq.append([nc, nr])
                visited[nc][nr] = True
    return cnt


for i in range(n):
    for j in range(n):
        if visited[i][j] is False and maps[i][j] == 1:
            answers.append(bfs(i, j))


answers.sort()

print(len(answers))
for answer in answers:
    print(answer)
