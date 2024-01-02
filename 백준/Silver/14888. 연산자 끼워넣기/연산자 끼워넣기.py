import sys
from collections import deque

sin = sys.stdin.readline
N = int(sin())
nums = list(map(int, sin().strip().split()))
ops = list(map(int, sin().strip().split()))
op_list = ["+", "-", "*", "/"]
max_val, min_val = -(sys.maxsize-1), sys.maxsize


def dfs(depth: int, arr):
    global max_val, min_val
    if depth == N:
        max_val = max(max_val, arr)
        min_val = min(min_val, arr)

    else:
        if ops[0] > 0:
            ops[0] -= 1
            dfs(depth+1, arr + nums[depth])
            ops[0] += 1

        if ops[1] > 0:
            ops[1] -= 1
            dfs(depth+1, arr - nums[depth])
            ops[1] += 1

        if ops[2] > 0:
            ops[2] -= 1
            dfs(depth+1, arr * nums[depth])
            ops[2] += 1

        if ops[3] > 0:
            ops[3] -= 1
            dfs(depth+1, int(arr / nums[depth]))
            ops[3] += 1


dfs(1, nums[0])

print(max_val)
print(min_val)

