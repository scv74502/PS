import heapq
import sys
"""
투 포인터 풀 생각이었는데, 왜 모음집에 이게 있는지는 모르겠다
오히려 우선순위 큐를 알고 활용할 생각을 할 수 있었으면 아주 쉽게 풀리는 문제이다
n번째 최대값을 반환하는 수이므로, n개의 최대값만 보관하는 우선순위 큐를 만든다
큐의 길이가 n 미만이면 삽입하고, n이 되면 최소값인 heapq의 맨 위값이 새 수보다 작으면 내보내고 새 수를 삽입한다
그러면 n개의 가장 큰 수 중에서 최소값을 알 수 있다
최대값(큐 내에서 최대이자 배열 중에서 최대)을 알고 싶으면 1개만 남을 때까지 모두 pop을 실행하거나, 음수 부호 붙이거나 하는 방법이 있을 것이다
"""


input = sys.stdin.readline

n = int(input())
hq = []

for _ in range(n):
    line = map(int, input().split())
    for num in line:
        if len(hq) < n:
            heapq.heappush(hq, num)
        else:
            if hq[0] < num:
                heapq.heappop(hq)
                heapq.heappush(hq, num)

print(hq[0])

