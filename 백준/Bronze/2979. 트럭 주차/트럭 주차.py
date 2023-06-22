import sys

prices = list(map(int, sys.stdin.readline().split(" ")))
records = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(3)]
records.sort(key=lambda x: x[0])

start = min([record[0] for record in records])
end = max([record[1] for record in records])
answer = 0

for time in range(start, end):
    cur = 0
    for record in records:
        if record[0] < time+1 <= record[1]:
            cur += 1
    answer += prices[cur-1] * cur

print(answer)
