import sys
import itertools


sin = sys.stdin.readline
TE, TS, TM = map(int, sin().split())
CE, CS, CM = 1, 1, 1

cur_year = 1

while CE != TE or CS != TS or CM != TM:
    cur_year += 1
    CE += 1
    CS += 1
    CM += 1

    if CE > 15:
        CE = 1

    if CS > 28:
        CS = 1

    if CM > 19:
        CM = 1

print(cur_year)
