import sys
from collections import deque

# 상 하 좌 우 좌상 우상 좌하 우하
mh = [-1, 1, 0, 0, -1, -1, 1, 1]
mw = [0, 0, -1, 1, -1, 1, -1, 1]
sin = sys.stdin.readline
map_arr = [[-1 for __ in range(51)] for _ in range(51)]
visited = [[False for __ in range(51)] for _ in range(51)]

while True:
    W, H = map(int, sin().split(" "))
    if W == 0 and H == 0:
        break

    for i in range(H):
        ipt = list(map(int, sin().split(" ")))
        for j in range(W):
            map_arr[i][j] = ipt[j]
            visited[i][j] = False

    cnt = 0
    dq = deque()

    # 모든 점을 탐색하며, 방문여부 체크 후 너비 우선 탐색 수행
    for i in range(H):
        for j in range(W):
            # 매 점마다 너비 우선 탐색 수행하며 체크
            if not visited[i][j] and map_arr[i][j] == 1:
                # 탐색하지 않았던 점이라면 섬 하나 추가함
                cnt += 1
                dq.append([i, j])
                visited[i][j] = True
                while dq:
                    ch, cw = dq.popleft()
                    # visited[ch][cw] = True

                    for d in range(8):
                        nh, nw = ch + mh[d], cw + mw[d]
                        if 0 <= nh < H and 0 <= nw < W:
                            if not visited[nh][nw]:
                                visited[nh][nw] = True
                                if map_arr[nh][nw] == 1:
                                    dq.append([nh, nw])

    print(cnt)
