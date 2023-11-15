import sys

si = sys.stdin.readline
N = int(si())
sours, bitters = [], []

for _ in range(N):
    s, b = map(int, si().split(" "))
    sours.append(s)
    bitters.append(b)

ans = sys.maxsize


def solution(cnt, sour, bitter, c):
    global ans
    if cnt == N:
        if ans > abs(sour - bitter) and c != 0:
            ans = abs(sour - bitter)
        return

    solution(cnt + 1, sour * sours[cnt], bitter + bitters[cnt], c + 1)
    solution(cnt + 1, sour, bitter, c)


solution(0, 1, 0, 0)
print(ans)
