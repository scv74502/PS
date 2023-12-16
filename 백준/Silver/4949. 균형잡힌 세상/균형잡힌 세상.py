import sys


def check(ipt: str) -> str:
    end = len(ipt) - 1
    stack = []

    for i in range(0, end):
        if ipt[i] == "(" or ipt[i] == "[":
            stack.append(ipt[i])
        elif ipt[i] == ")" or ipt[i] == "]":
            if not stack or (stack[-1] == "(" and ipt[i] == "]") or (stack[-1] == "[" and ipt[i] == ")"):
                return "no"

            elif (stack[-1] == "(" and ipt[i] == ")") or (stack[-1] == "[" and ipt[i] == "]"):
                stack.pop()

    if stack:
        return "no"
    else:
        return "yes"


sin = sys.stdin.readline
while True:
    ipt_str = sin().rstrip()
    if ipt_str == '.':
        break
    print(check(ipt_str))