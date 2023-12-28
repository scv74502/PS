from collections import deque
import sys


sin = sys.stdin.readline
N, M, K, X = map(int, sin().split())
dist = [sys.maxsize for i in range(0, N+1)]
dist[X] = 0
graph = [[] for _ in range(N+1)]

for _ in range(M):
    u, v = map(int,sin().split())
    graph[u].append(v)

dq = deque()
dq.append(X)
while dq:
    cur = dq.popleft()
    for vert in graph[cur]:
        cost = dist[cur] + 1
        # print(vert)
        if cost < dist[vert]:
            dist[vert] = cost
            dq.append(vert)

ans = [i for i in range(len(dist)) if dist[i] == K]
ans.sort()

if not ans:
    print(-1)
else:
    for num in ans:
        print(num)

