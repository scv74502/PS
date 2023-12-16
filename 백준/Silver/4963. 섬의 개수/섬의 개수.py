"""
BFS 사용시, 입력 크기가 50으로 한정되어 있으므로 미리 만든 뒤에 섬 입력받음 + visited도 같은 방식으로 처리해야 시간초과 발생 안함
함수로 넘기기, 동적으로 리스트 입력받기, visited 동적으로 생성하기 순으로 각 요소를 제거 후, 큐에 넣을지 체크하기 전 방문처리 로직 추가하니 시간 초과 미발생
"""

import sys
from collections import deque

# 상 하 좌 우 좌상 우상 좌하 우하
mh = [-1, 1, 0, 0, -1, -1, 1, 1]
mw = [0, 0, -1, 1, -1, 1, -1, 1]
sin = sys.stdin.readline
map_arr = [[-1 for __ in range(51)] for _ in range(51)]
visited = [[False for __ in range(51)] for _ in range(51)]
sys.setrecursionlimit(2602)


# DFS - 너비 우선 탐색을 사용함
def dfs(height: int, width: int):
    visited[height][width] = True
    for d in range(8):
        nh, nw = height + mh[d], width + mw[d]
        if 0 <= nh < H and 0 <= nw < W:
            if not visited[nh][nw]:
                visited[nh][nw] = True
                if map_arr[nh][nw] == 1:
                    dfs(nh, nw)


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

    for i in range(H):
        for j in range(W):
            if not visited[i][j] and map_arr[i][j] == 1:
                cnt += 1
                dfs(i, j)

    # BFS - 모든 점을 탐색하며, 방문여부 체크 후 너비 우선 탐색 수행
    # for i in range(H):
    #     for j in range(W):
    #         # 매 점마다 너비 우선 탐색 수행하며 체크
    #         if not visited[i][j] and map_arr[i][j] == 1:
    #             # 탐색하지 않았던 점이라면 섬 하나 추가함
    #             cnt += 1
    #             dq.append([i, j])
    #             visited[i][j] = True
    #             while dq:
    #                 ch, cw = dq.popleft()
    #
    #                 for d in range(8):
    #                     nh, nw = ch + mh[d], cw + mw[d]
    #                     if 0 <= nh < H and 0 <= nw < W:
    #                         if not visited[nh][nw]:
    #                             visited[nh][nw] = True
    #                             if map_arr[nh][nw] == 1:
    #                                 dq.append([nh, nw])

    print(cnt)
