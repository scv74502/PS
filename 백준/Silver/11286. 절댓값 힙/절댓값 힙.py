import sys
import heapq

min_heap = []
max_heap = []
# print(max(max_heap))

input = sys.stdin.readline

for _ in range(int(input())):
    x = int(input())
    if x:
        if x > 0:
            heapq.heappush(min_heap, x)
        else:
            heapq.heappush(max_heap, -x)
    else:
        # 양수 저장하는 힙이 안 비었고
        if min_heap:
            # 양수, 음수 힙이 둘다 안 비었으면
            if max_heap:
                # 양수 힙의 최소값이 음수 힙의 절대값보다 크다면
                if min_heap[0] < abs(-max_heap[0]):
                    print(heapq.heappop(min_heap))
                else:
                    print(-heapq.heappop(max_heap))
            else:
                print(heapq.heappop(min_heap))
        else:
            if max_heap:
                print(-heapq.heappop(max_heap))
            else:
                print(0)
