import sys


us, uh = map(int, sys.stdin.readline().split()) # 못 들어봄, 못 봤음
usm = set()
ush = []

for _ in range(us):
    name = sys.stdin.readline().strip()
    if name not in usm:
        usm.add(name)

for _ in range(uh):
    name = sys.stdin.readline().strip()
    if name in usm:
        ush.append(name)

print(len(ush))
ush.sort()
for name in ush:
    print(name)


