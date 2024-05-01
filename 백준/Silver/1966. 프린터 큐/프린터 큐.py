from collections import deque
import sys


tc = int(sys.stdin.readline())

for _ in range(tc):
    N, tgt_idx = map(int, sys.stdin.readline().split())
    ipt_list = list(map(int, sys.stdin.readline().split()))
    priorities = sorted(ipt_list, reverse=False)
    queue = deque(ipt_list)
    print_cnt = 0

    while True:
        if 0 == tgt_idx:
            if queue[0] == priorities[-1]:
                queue.popleft()
                print_cnt += 1
                print(print_cnt)
                priorities.pop()
                break
            else:
                queue.append(queue.popleft())
                tgt_idx = len(queue) - 1
        else:
            if queue[0] == priorities[-1]:
                queue.popleft()
                print_cnt += 1
                priorities.pop()
                tgt_idx -= 1
            else:
                queue.append(queue.popleft())
                tgt_idx -= 1


