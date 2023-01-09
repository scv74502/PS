import sys
import heapq

max_heap = []
# print(max(max_heap))

n = int(sys.stdin.readline())

for i in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        if len(max_heap) == 0:
            print(0)
        else:
            print(-heapq.heappop(max_heap))
    else:
        heapq.heappush(max_heap, -num)