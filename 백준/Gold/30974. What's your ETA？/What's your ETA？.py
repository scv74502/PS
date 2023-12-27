"""
값이 매우 커서 시간초과가 자주 발생함
먼저 소수 관련 처리를 한 후에, 간선을 그래프에 추가할 때와 우선순위 큐에 값 넣을때 두 번 모두 소수 테이블 이용하여 검증함
소수 판별 알고리즘에서도 최대한 효율적인 방법이 아니면 pypy3에서도 시간초과 발생
"""
import sys
import math
import heapq


def eratosthenes(num: int):
    MAX = num + 1
    LIM = int(num ** 0.5) + 1
    RSET = lambda strt, end, gap: set(range(strt, end, gap))

    # 5 (mod 6)과 1 (mod 6)을 참으로 설정한다. 이들은 2의 배수도 아니고 3의 배수도 아닌 숫자집합이다.
    # 단, 1은 소수가 아니기에 1 (mod 6)은 7부터 시작한다.
    prime = RSET(5, MAX, 6) | RSET(7, MAX, 6)
    if num > 2: prime.add(3)  # 3 추가
    if num > 1: prime.add(2)  # 2 추가
    for i in range(5, LIM, 6):
        # 5 (mod 6) 부분
        if i in prime:
            prime -= RSET(i * i, MAX, i * 6) | RSET(i * (i + 2), MAX, i * 6)
        # 1 (mod 6) 부분
        j = i + 2
        if j in prime:
            prime -= RSET(j * j, MAX, j * 6) | RSET(j * (j + 4), MAX, j * 6)

    return prime


sin = sys.stdin.readline
N, M = map(int, sin().split(" "))
graph = [[] for _ in range(N + 1)]
# 시작점 1에서 나머지 점들까지 거리
distance = [sys.maxsize for _ in range(N + 1)]
# 시작점 1과 자기 자신의 거리는 1
distance[1] = 0
codes = list(map(int, sin().split(" ")))

# 소수 처리 부분 코드
max_code = max(codes) * 2
pmt = eratosthenes(max_code + 1)

for _ in range(M):
    u, v, w = map(int, sin().split())
    # 처리 가능 간선으로만
    if codes[u-1] + codes[v-1] in pmt:
        graph[u].append([v, w])
        graph[v].append([u, w])

# 다익스트라 이용해 길 찾기 시작
hq = []
heapq.heappush(hq, [0, 1])  # 초기에 우선순위 큐에다 비용 0과 시작점 투입

while hq:
    cw, cv = heapq.heappop(hq)
    if distance[cv] < cw:
        continue

    for line in graph[cv]:
        nv, nw = line
        cost = distance[cv] + nw
        # 양 정류장 간의 코드 합이 소수이고, 거리상 현재의 비용이 거리 저장값보다 작다면
        if codes[nv-1] + codes[cv-1] in pmt and cost < distance[nv]:
            distance[nv] = cost
            heapq.heappush(hq, [cost, nv])

if distance[N] == sys.maxsize:
    print("Now where are you?")
else:
    print(distance[N])
