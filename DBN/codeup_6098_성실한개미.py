import sys

r, c = 10, 10
map = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(r)]

# print(map)
x, y = 1, 1
while(map[x][y] != 2):
    map[x][y] = 9
    if y + 1 < c and map[x][y+1] != 1:
        y += 1
    elif x + 1 < r and map[x+1][y] != 1:
        x += 1
    else:
        break
map[x][y] = 9
for i in range(r):
    for j in range(c):
        print(map[i][j], end=" ")
    print()