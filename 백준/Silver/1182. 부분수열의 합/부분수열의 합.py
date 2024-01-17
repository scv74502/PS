import sys

sys.setrecursionlimit(10000)
sin = sys.stdin.readline


def bt(tot: int, cur: int) -> None:
    global S, cnt
    if cur == N:
        if tot == S:
            cnt += 1
        return

    # 지금 수를 더하는 경우와 더하지 않는 경우
    bt(tot, cur + 1)
    bt(tot + nums[cur], cur + 1)



if __name__ == "__main__":
    N, S = map(int, sin().split())
    nums = list(map(int, sin().split()))
    cnt = 0
    bt(0, 0)
    if S == 0:
        cnt -= 1
    print(cnt)
