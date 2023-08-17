import sys

input = sys.stdin.readline
N, M = map(int, input().strip().split(" "))
nums = sorted(list(map(int, input().strip().split(" "))))
res = []


def bt(num_list):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return
    temp = 0
    for i in range(0, len(num_list)):
        if temp != nums[i]:
            res.append(num_list[i])
            temp = num_list[i]
            bt(num_list)
            res.pop()


bt(nums)