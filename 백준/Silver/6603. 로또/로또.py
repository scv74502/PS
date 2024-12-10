import sys


def bt(cnt, idx):
    if cnt == 6:
        print(*output)
        return

    for i in range(idx, K):
        output.append(S[i])
        bt(cnt + 1, i + 1)
        output.pop()


while True:
    ipt = list(map(int, sys.stdin.readline().split()))
    K = int(ipt[0])
    S = ipt[1:]

    if K == 0:
        exit()

    output = []
    bt(0, 0)
    print()
