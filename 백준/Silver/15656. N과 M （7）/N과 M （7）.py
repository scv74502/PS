import sys

input = sys.stdin.readline
N, M = map(int, input().strip().split(" "))
nums = sorted(list(map(int, input().strip().split(" "))))
res = []


def bt(num_list):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return

    for i in range(len(num_list)):
        res.append(num_list[i])
        bt(num_list)
        res.pop()


bt(nums)
