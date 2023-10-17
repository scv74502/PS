import sys
import itertools


sin = sys.stdin.readline
tinies = [int(sin()) for _ in range(9)]
tinies.sort()
# print(tinies)

for comb in itertools.combinations(tinies, 7):
    if sum(comb) == 100:
        for num in sorted(comb):
            print(num)
        break