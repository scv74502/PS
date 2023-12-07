import sys


sys.setrecursionlimit(150000)
sin = sys.stdin.readline
N, M = map(int, sin().strip().split(" "))    # 정점 수, 간선 수
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, sin().strip().split(" "))
    graph[u].append(v)
    graph[v].append(u)

visited = [False for _ in range(N + 1)]
# 방문 기록 저장하는 리스트, 0으로 하면 미방문도 한번에 처리 가능하다!ㄴ
ans = 0


def dfs(visit: int):
    visited[visit] = True
    for vertex in graph[visit]:
        if not visited[vertex]:
            dfs(vertex)


for i in range(1, N+1):
    if not visited[i]:
        ans += 1
        dfs(i)

print(ans)