import sys
from collections import deque


sin = sys.stdin.readline
computers = int(sin())
lines = int(sin())

graph = [[] for _ in range(computers+1)]    # 이중 리스트로 그래프의 점과 연결된 점 처리
visited = [0] * (computers+1)   # 그래프의 점 수만큼 방문됭 배열 처리하기

# undirected graph이므로 쌍방에 대하여 연결 처리함
for _ in range(lines):
    u, v = map(int, sin().split())
    graph[u].append(v)
    graph[v].append(u)

# 처음에 1번점(기준점)부터 방문 시작함
visited[1] = 1
dq = deque([1])

while dq:
    cur = dq.popleft()
    for np in graph[cur]:
        if visited[np] == 0:
            dq.append(np)
            visited[np] = 1

# visited 배열은 1번 점과 연결된 정점을 방문했는지 체크함
print(sum(visited)-1)   # 1번 배열(visited[1])은 세지 않으므로 1 빼줘야 함