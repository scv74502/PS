import heapq
import sys


sin = sys.stdin.readline
N, D = map(int, sin().split())
dist = [i for i in range(0, D+1)]
hq = [list(map(int, sin().split())) for i in range(N)]
heapq.heapify(hq)

while hq:
    # start, end, range
    s, e, r = heapq.heappop(hq)
    if s >= D or e > D:
        continue

    cost = dist[s] + r
    if cost >= dist[e]:
        continue

    dist[e] = min(cost, dist[e])

    for i in range(e, D+1):
        dist[i] = min(dist[i], dist[e] + i - e)

print(dist[D])