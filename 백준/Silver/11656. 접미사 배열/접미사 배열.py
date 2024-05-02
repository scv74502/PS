import sys


ipt = sys.stdin.readline().rstrip()
tails = [ipt]

for i in range(1, len(ipt)):
    tails.append(ipt[i:])

tails.sort()

for tail in tails:
    print(tail)
