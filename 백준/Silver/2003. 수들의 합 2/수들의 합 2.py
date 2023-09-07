import sys


input = sys.stdin.readline
N, M = map(int, input().split(" "))

arr = list(map(int, input().split(" ")))
# print(N, M, arr)

end, cur, ans = 0, 0, 0

for start in range(N):
    while cur < M and end < N:
        cur += arr[end]
        end += 1
    if cur == M:
        ans += 1

    cur -= arr[start]

print(ans)

