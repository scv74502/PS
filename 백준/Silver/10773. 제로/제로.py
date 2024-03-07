import sys


sin = sys.stdin.readline
N = int(sin())
stack = []
ans = 0

for _ in range(N):
    ipt = int(sin())
    if ipt == 0:
        rmv = stack.pop()
        ans -= rmv
    else:
        stack.append(ipt)
        ans += ipt

print(ans)