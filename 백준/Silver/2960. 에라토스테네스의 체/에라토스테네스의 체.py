import sys


sin = sys.stdin.readline
num, tgt = map(int, sin().split(" "))


def solution(N, K):
    pnt = [True for i in range(N+1)]
    tot_idx = 0

    for i in range(2, int(N ** 2) + 1):
        if pnt[i]:
            j = 1
            while i * j <= N:
                if pnt[i * j]:
                    pnt[i * j] = False
                    # print(i * j)
                    tot_idx += 1

                if tot_idx == K:
                    return i * j
                j += 1


print(solution(num, tgt))