import sys


input = sys.stdin.readline
N, K = map(int, input().split())
num_list = list(map(int, input().strip().split(" ")))

sum_val = sum(num_list[:K])
lp, rp = 0, K-1
res = sum_val

for i in range(K, N):
    sum_val += num_list[i] - num_list[lp]
    # print(i, lp, sum_val)
    lp += 1
    if sum_val > res:
        res = sum_val


print(res)

