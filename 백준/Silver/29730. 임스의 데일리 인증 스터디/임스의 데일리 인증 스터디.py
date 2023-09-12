import sys


input = sys.stdin.readline
N = int(input())
# job, boj = set(), set()
job, boj = [], []

for _ in range(N):
    ipt = input().strip()
    if "/" in ipt:
        boj.append(ipt)
        # print(ipt[7:])
    else:
        job.append(ipt)

# job = list(job)
# boj = list(boj)

job.sort(key=lambda x:(len(x), x))
boj.sort(key=lambda x:(int(x[7:])))

if job:
    for j in job:
        print(j)

if boj:
    for ps in boj:
        print(ps)