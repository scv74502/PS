"""
BFS 사용시, 입력 크기가 50으로 한정되어 있으므로 미리 만든 뒤에 섬 입력받음 + visited도 같은 방식으로 처리해야 시간초과 발생 안함
함수로 넘기기, 동적으로 리스트 입력받기, visited 동적으로 생성하기 순으로 각 요소를 제거 후, 큐에 넣을지 체크하기 전 방문처리 로직 추가하니 시간 초과 미발생
-> 함수로 넘기기나 동적 입력 등이 문제가 아니라, 대각선까지 탐색하므로 8번 탐색하는 과정에서 시간 초과가 발생함..
-->> 해결하기 위해서 탐색 시에 방문했는지 체크 -> 처음 방문이면 방문체크 -> 섬인지 체크하고 섬이면 큐에 넣음 순으로 로직을 변경하여 탐색 횟수를 최소화하기
"""

import sys
from collections import deque

# 상 하 좌 우 좌상 우상 좌하 우하
mh = [-1, 1, 0, 0, -1, -1, 1, 1]
mw = [0, 0, -1, 1, -1, 1, -1, 1]
sin = sys.stdin.readline
sys.setrecursionlimit(2602)
map_arr, visited = None, None


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


def bfs(arr: list) -> int:
    cnt = 0
    dq = deque()
    width, height = len(arr[0]), len(arr)

    # 모든 점을 탐색하며, 방문여부 체크 후 너비 우선 탐색 수행
    for i in range(height):
        for j in range(width):
            # 매 점마다 너비 우선 탐색 수행하며 체크
            if not visited[i][j] and arr[i][j] == 1:
                # 탐색하지 않았던 점이라면 섬 하나 추가함
                cnt += 1
                dq.append([i, j])
                while dq:
                    ch, cw = dq.popleft()
                    visited[ch][cw] = True

                    for d in range(8):
                        nh, nw = ch + mh[d], cw + mw[d]
                        if 0 <= nh < height and 0 <= nw < width:
                            if not visited[nh][nw]:
                                visited[nh][nw] = True
                                if arr[nh][nw] == 1:
                                    dq.append([nh, nw])

    return cnt


while True:
    W, H = map(int, sin().split(" "))

    if W == 0 and H == 0:
        break

    map_arr = [list(map(int, sin().split(" "))) for _ in range(H)]
    # noinspection PyRedeclaration
    visited = [[False for _ in range(W)] for __ in range(H)]
    print(bfs(map_arr))
