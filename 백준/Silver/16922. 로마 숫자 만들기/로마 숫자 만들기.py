import sys


si = sys.stdin.readline
N = int(si())
nums = [1, 5, 10, 50]
res, ans = [], set()


def bt(num: int):
    if len(res) == N and sum(res) not in ans:
        ans.add(sum(res))
        return

    for i in range(num, 4):
        if len(res) < N:
            res.append(nums[i])
            bt(i)
            res.pop()


bt(0)
print(len(ans))