import sys


input = sys.stdin.readline
N, M = map(int, input().split())
nums = list(map(int, input().strip().split(" ")))
nums.sort()
res = []

# print(N, M)
# print(nums)

def bt(nums):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return

    for i in range(len(nums)):
        if nums[i] not in res:
            res.append(nums[i])
            bt(nums)
            res.pop()

bt(nums)