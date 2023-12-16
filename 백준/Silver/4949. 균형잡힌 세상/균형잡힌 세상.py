"""
우선 함수로 따로 빼지 않으면 print("no") 이후 흐름 제어가 귀찮아서, return하면 끝나는 함수로 로직을 빼니 처리가 편했음
처음에는 10% 부분에서 틀렸습니다 에러가 발생했으나, 
if not stack or (stack[-1] == "(" and ipt[i] == "]") or (stack[-1] == "[" and ipt[i] == ")"):
부분을 추가하고 나니 정답처리됨. 상술한 케이스에 대해서 고려하지 않았던 듯 하며, 테스트 케이스 생각하는 습관 들여야겠다 싶었음
"""
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