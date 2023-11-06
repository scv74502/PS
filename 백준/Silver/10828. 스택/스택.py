import sys


stack = []
si = sys.stdin.readline
N = int(si())

for _ in range(N):
    ipt = si().strip().split()
    # print("order :", ipt[0])
    if len(ipt) == 1:
        if ipt[0] == "top":
            if not stack:
                print(-1)
            else:
                print(stack[-1])
        elif ipt[0] == "size":
            print(len(stack))
        elif ipt[0] == "empty":
            if stack:
                print(0)
            else:
                print(1)
        elif ipt[0] == "pop":
            if not stack:
                print(-1)
            else:
                print(stack.pop())
    else:
        ipt[1] = int(ipt[1])
        stack.append(ipt[1])
