import sys
import heapq


sin = sys.stdin.readline
V, E = map(int, sin().split(" "))
K = int(sin().strip())
distance = [sys.maxsize for _ in range(V + 1)]
graph = [[] for _ in range(V + 1)]
visited = [False for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, sin().split(" "))
    # u번 정점에서 v로 가는 비용이 w라는 의미이다
    graph[u].append([v, w])


def dijkstra(start: int):
    hq = []
    heapq.heappush(hq, [0, start])
    # 자기 자신과의 거리는 0이다
    distance[start] = 0

    while hq:
        dist, vertex = heapq.heappop(hq)
        # 이미 최소 거리로 처리된 정점은 무시한다
        if distance[vertex] < dist:
            continue
        for i in graph[vertex]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(hq, [cost, i[0]])


dijkstra(K)

for i in range(1, V+1):
    if distance[i] == sys.maxsize:
        print("INF")
    else:
        print(distance[i])