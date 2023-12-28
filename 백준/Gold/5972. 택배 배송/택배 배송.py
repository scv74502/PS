import heapq
import sys


sin = sys.stdin.readline
N, M = map(int, sin().split())
graph = [[] for _ in range(N+1)]
dist = [sys.maxsize for _ in range(N+1)]
dist[1] = 0

for _ in range(M):
    u, v, w = map(int, sin().split(" "))
    graph[u].append([w, v])
    graph[v].append([w, u])

hq = [[0, 1]]
while hq:
    cw, cv = heapq.heappop(hq)
    for line in graph[cv]:
        nw, nv = line
        cost = dist[cv] + nw
        if cost >= dist[nv]:
            continue
        dist[nv] = cost
        heapq.heappush(hq, [nw, nv])

print(dist[N])
