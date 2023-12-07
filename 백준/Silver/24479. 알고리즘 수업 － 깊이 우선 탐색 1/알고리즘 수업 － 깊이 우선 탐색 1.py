import sys
from typing import List


sys.setrecursionlimit(150000)
sin = sys.stdin.readline
N, M, R = map(int, sin().strip().split(" "))    # 정점 수, 간선 수, 시작 정점
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, sin().strip().split(" "))
    graph[u].append(v)
    graph[v].append(u)

# 그래프 오름차순 정렬
for arr in graph:
    if arr:
        arr.sort()

visited = [0 for _ in range(N + 1)]
# 방문 기록 저장하는 리스트, 0으로 하면 미방문도 한번에 처리 가능하다!ㄴ
idx = 1


def bfs(visit: int):
    global idx
    visited[visit] += idx
    idx += 1


    for v in graph[visit]:
        if visited[v]==0:
            bfs(v)


bfs(R)

for i in range(1, N+1):
    print(visited[i])