import sys


sys.setrecursionlimit(100000)
sin = sys.stdin.readline
a, b, c, d, e, f = map(int, sin().split())


def bt():
    global a, b, c, d, e, f
    for x in range(-999, 1000):
        for y in range(-999, 1000):
            if a * x + b * y == c and d * x + e * y == f:
                return x, y


ax, ay = bt()
print(ax, ay)