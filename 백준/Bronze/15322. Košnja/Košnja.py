import sys

repeat = int(sys.stdin.readline())

for _ in range(repeat):
    N, M = map(int, sys.stdin.readline().split(" "))
    print((min(N, M) - 1) * 2)