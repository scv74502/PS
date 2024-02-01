import sys


sin = sys.stdin.readline
N, K = map(int, sin().split())
nums = [i for i in range(1, N+1)]
idx = K - 1
ans = []

while nums:
    # print(idx ,nums[idx])
    ans.append(nums.pop(idx))
    N -= 1
    idx -= 1

    idx += K
    while idx >= N and nums:
        idx -= N


print(f'<{", ".join(map(str, ans))}>')




