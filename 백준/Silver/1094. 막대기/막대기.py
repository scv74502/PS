import sys
"""
너무 어렵게 생각하지 말고, 나무 막대기의 길이가 몇 개의 작은 막데기로 나뉘는지 아는 것
즉, 이진수로 바꿨을 때 1의 개수를 세는 것이라고 생각하면 되는 문제이다
문제는 아주 쉬우나, 아이디어 떠올리기가 어렵다
"""


sin = sys.stdin.readline
num = int(sin())
bi_num = bin(num)[2:]
ans = 0

for bit in bi_num:
    if bit == '1':
        ans += 1

print(ans)