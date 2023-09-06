import sys


""""
투포인터 알고리즘은 자연수(양수)에서만 기능함
구간합 m인 구간인 S와 E가 있다고 가정하자
l이 S가 되기 전까지 r은 E를 넘어갈 수 없다
또한 r이 E가 되기 전까지 l은 S를 넘어갈 수 없다
"""
input = sys.stdin.readline
n, m = map(int, input().split(" "))
arr = list(map(int, input().split(" ")))
r, sum, ans = 0, 0, 0


for l in range(n):
    while sum < m and r < n:
        sum += arr[r]
        r += 1

    if sum == m:
        ans += 1

    sum -= arr[l]


print(ans)