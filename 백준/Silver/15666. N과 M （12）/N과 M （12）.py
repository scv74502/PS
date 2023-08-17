import sys

input = sys.stdin.readline
N, M = map(int, input().strip().split(" "))
nums = sorted(list(map(int, input().strip().split(" "))))
visited = [False] * N
res = []


def bt(start):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return
    temp = 0
    for i in range(start, N):
        if temp != nums[i]:
            res.append(nums[i])
            temp = nums[i]
            bt(i)
            res.pop()


bt(0)