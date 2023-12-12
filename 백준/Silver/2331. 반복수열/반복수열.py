import sys


si = sys.stdin.readline
A, P = map(int, si().split(" "))
D = [0 for _ in range(2)]
D[1] = A
record = dict()
next_num, idx, dup_idx = 0, 1, 0
record[A] = idx
cur_num = A

while True:
    digit = 0
    while True:
        if 10 ** (digit+1) > cur_num:
            break
        else:
            digit += 1

    while cur_num > 0:
        next_num += (cur_num // (10 ** digit)) ** P
        cur_num = cur_num % (10 ** digit)
        digit -= 1

    if next_num in record:
        dup_idx = record[next_num]
        break
    else:
        idx += 1
        cur_num = next_num
        record[next_num] = idx
        next_num = 0

print(dup_idx-1)