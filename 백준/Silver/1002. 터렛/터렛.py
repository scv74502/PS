import sys
import math


input = sys.stdin.readline
rpt = int(input())
for _ in range(rpt):
    j1, p1, r1, j2, p2, r2 = map(int, input().split())
    # 원의 방정식 통해서 두 원 중심의 거리 구함
    distance = math.sqrt((j1 - j2) ** 2 + (p1 - p2) ** 2)
    # 중심 거리가 0이고 반지름이 같으면 같은 원, 무한대
    if distance == 0 and r1 == r2:
        print(-1)
    # 두 원이 내접 혹은 외접일 때
    elif abs(r1-r2) == distance or r1 + r2 == distance:
        print(1)
    # 두 원이 두 점에서 만난다면
    elif abs(r1-r2) < distance < (r1 + r2):
        print(2)
    # 두 원의 접점이 없다면
    else:
        print(0)


