"""
Stack 자료구조를 이용해 보자
1. 글자를 계속 스택에 삽입
2. 맨 뒤의 두 글자가 같으면 두 번 pop()으로 제거
"""


def solution(s):
    stack = []
    for char in s:
        stack.append(char)
        
        if len(stack) > 1 and stack[-1] == stack[-2]:
            stack.pop()
            stack.pop()
    
    if len(stack) == 0:
        return 1
    else:
        return 0
        
    

        
            
        
        
        