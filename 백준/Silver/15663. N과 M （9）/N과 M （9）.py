import sys

input = sys.stdin.readline
N, M = map(int, input().strip().split(" "))
nums = sorted(list(map(int, input().strip().split(" "))))
visited = [False] * N
res = []


def bt(num_list):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return
    idx = 0
    for i in range(0, len(num_list)):
        if not visited[i] and idx != nums[i]:
            visited[i] = True
            res.append(num_list[i])
            idx = nums[i]
            bt(num_list)
            visited[i] = False
            res.pop()


bt(nums)