import sys

N = int(sys.stdin.readline())
graph = [list(sys.stdin.readline().strip()) for _ in range(N)]
is_connected = [[0 for __ in range(N)] for _ in range(N)]

for i in range(N):
    for j in range(N):
        for k in range(N):
            if i == j: continue
            if graph[i][j] == 'Y' or (graph[i][k] == 'Y' and graph[k][j] == 'Y'):
                is_connected[i][j] = 1

answer = -1
for row in is_connected:
    answer = max(answer, sum(row))

print(answer)