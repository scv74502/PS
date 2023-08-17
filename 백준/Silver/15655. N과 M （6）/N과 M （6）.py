import sys


input = sys.stdin.readline
N, M = map(int, input().strip().split(" "))
nums = sorted(list(map(int, input().strip().split(" "))))
res = []

def bt(nums):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return

    for i in range(len(nums)):
        if nums[i] not in res:
            res.append(nums[i])
            bt(nums[i+1:])
            res.pop()

bt(nums)