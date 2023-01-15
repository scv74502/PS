from bisect import bisect_left, bisect_right
import sys

input = sys.stdin.readline

def bi_search(li, tgt):
    l, r, mid = 0, len(li)-1, 0
    while l <= r:
        mid = (l + r) // 2
        if li[mid] == tgt:
            return 1
        if li[mid] > tgt:
            r = mid-1
        if li[mid] < tgt:
            l = mid + 1
    return 0



n = int(input())
num_list = list(map(int, input().split(" ")))
num_list.sort()

m = int(input())
tgt_list = list(map(int, input().split(" ")))

for num in tgt_list:
    print(bi_search(num_list, num))
