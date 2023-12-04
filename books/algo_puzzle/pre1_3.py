M, N = 10, 100

table = [0] * (M + 1)

for i in range(0, M + 1):
    table[i] = [0] * (N + 1)
    table[i][0] = 1

print(table)

for i in range(1, M + 1):
    for j in range(2, N + 1):
        if (i >= 2) and (j >= i):
            table[i][j] = table[i][j-1]
        if i > 2:
            table[i][j] += table[i-1][j]

print(table[M][N])