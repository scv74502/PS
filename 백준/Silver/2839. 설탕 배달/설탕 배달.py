import sys


sin = sys.stdin.readline
sugar = int(sin())
ans = 0

while sugar >= 0:
    if sugar % 5 == 0:
        ans += sugar // 5
        print(ans)
        break
    sugar -= 3
    ans += 1
else:
    print(-1)


