import sys


sin = sys.stdin.readline
R, C = map(int, sin().split())
alphabets = [list(sin().rstrip()) for _ in range(R)]
max_range, cur_range = 1, 1

"""
이미 방문한 위치라도, 다른 탐색에서는 자신의 알파벳 리스트에 포함되어 있지 않으면 방문할 수 있음
그리고 한 탐색 시도에서 방문했던 점은 시작점 포함해서 방문했던 점은 방문기록 리스트에 포함되어서 중복 탐색이 자체적으로 예방 가능함

그리고 bfs를 통해 매 탐색마다 리스트를 저장하면 시간 초과가 발행하므로, dfs를 사용하기로 함..
따라서 bfs에서 visited 사용하지 않던 것과 다르게 사용함
"""

# 상, 하, 좌, 우
mx = [1, -1, 0, 0]
my = [0, 0, -1, 1]
visited = [False] * (ord('Z') - ord('A') + 1)

def dfs(x, y):
    start = alphabets[y][x]
    visited[ord(start) - ord('A')] = True
    global cur_range
    global max_range

    for m in range(4):
        nx, ny = x + mx[m], y + my[m]

        if 0 <= nx < C and 0 <= ny < R:
            next_alphabet = ord(alphabets[ny][nx]) - ord('A')

            if visited[next_alphabet]:
                continue

            cur_range += 1
            max_range = max(cur_range, max_range)

            dfs(nx, ny)


    # 범위에 각별히 조심하기, 내 주변에서 4방향 탐색을 돌 동안에는 거리나 방문기록 정보를 가지고 있어야 함
    cur_range -= 1
    visited[ord(start) - ord('A')] = False


dfs(0, 0)
print(max_range)

