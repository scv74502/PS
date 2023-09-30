"""
자료구조 활용에 아직 미숙하니 스택 문제를 좀 더 풀여봐야 한다
커서를 옮기는 동작을 스택을 통한다고 접근하면 됨
"""
import sys


sin = sys.stdin.readline
stk1 = list(sin().strip())
stk2 = []
rpt = int(sin())


for _ in range(rpt):
    ipt = sin()
    if ipt[0] == 'P':
        stk1.append(ipt[2])


    elif ipt[0] == 'L':
        if stk1:
            stk2.append(stk1.pop())

    elif ipt[0] == 'D':
        if stk2:
            stk1.append(stk2.pop())

    else:
        if stk1:
            stk1.pop()

stk1.extend(reversed(stk2))
print(''.join(stk1))