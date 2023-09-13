import sys
from collections import  deque
"""
시간 제한, 메모리 제한 때문에 2차원 배열을 사용하면 N이 커지면 시간 초과가 남.. 잘 보기
따라서 방문체크 배열이나 기물 유무 배열을 deque로 대체하여 in을 통해 검사하기
"""


input = sys.stdin.readline
N, K = map(int, input().split())

# 상, 하, 좌, 우 이동
mx = [0, 0, -2, 2]
my = [2, -2, 0, 0]

checked = set()
dq = deque()

for _ in range(K):
    x, y = map(int, input().split())
    # 문제 잘 읽어야 함! 프로그래밍은 0부터지만 문제는 1부터
    checked.add((x-1, y-1))
    dq.append([x-1, y-1])

while dq:
    cx, cy = dq.popleft()
    for m in range(4):
        nx, ny = cx + mx[m], cy + my[m]
        if 0 <= nx < N and 0 <= ny < N and (nx, ny) not in checked:
            checked.add((nx, ny))

print(len(checked)-K)
