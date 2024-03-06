import sys
import heapq


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
dist = [sys.maxsize for _ in range(N + 1)]
graph = [[] for _ in range(N+1)]
visited = [False for _ in range(N + 1)]

for _ in range(M):
    u, v, w = map(int, sys.stdin.readline().split())
    graph[u].append([v, w])

sp, ep = map(int, sys.stdin.readline().split())
# 자기 자신의 위치는 0



def dijkstra(start):
    hq = []
    heapq.heappush(hq, [0, start])
    dist[start] = 0

    while hq:
        distance, vertex = heapq.heappop(hq)
        if dist[vertex] < distance:
            continue

        for line in graph[vertex]:
            nt, nc = line[0], line[1] # 다음 마을, 다음 비용
            cost = distance + nc
            # print(nt, nc)
            if cost < dist[nt]:
                dist[nt] = cost
                heapq.heappush(hq, [cost, nt])


dijkstra(sp)

print(dist[ep])
