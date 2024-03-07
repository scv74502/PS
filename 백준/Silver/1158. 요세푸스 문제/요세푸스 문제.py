import sys
from collections import deque


sin = sys.stdin.readline
N, K = map(int, sin().strip().split(" "))
left = deque([num for num in range(1, N+1)])
right = deque()
ans = []
is_left = True

#
while len(ans) < N:
    # print(ans)
    for _ in range(K-1):
        if not left:
            is_left = False
        elif not right:
            is_left = True

        if is_left:
            right.append(left.popleft())
        elif not is_left:
            left.append(right.popleft())

    if not left:
        is_left = False
    elif not right:
        is_left = True

    if is_left:
        ans.append(str(left.popleft()))
    elif not is_left:
        ans.append(str(right.popleft()))

# 출력 파트 부분은 다른 풀이 참조했음
print("<", ", ".join(ans)[:], ">", sep='')


