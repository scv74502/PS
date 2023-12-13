import sys

sin = sys.stdin.readline
tc = int(sin())


def check(string: str):
    stack = []
    for ch in string:
        if ch == '(':
            stack.append(ch)
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False
    else:
        return True


for _ in range(tc):
    ipt = sin().strip()

    if check(ipt):
        print("YES")
    else:
        print("NO")
