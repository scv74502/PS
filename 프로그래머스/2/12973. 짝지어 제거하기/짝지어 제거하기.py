def solution(s):
    stack1 = list(s)[::-1]
    stack2 = []
    
    while stack1:        
        if stack1 and stack2 and stack1[-1] == stack2[-1]:
            stack1.pop()
            stack2.pop()
            continue
        
        stack2.append(stack1.pop())
        if stack1 and stack1[-1] == stack2[-1]:
            stack1.pop()
            stack2.pop()
        # print(stack1, stack2)
    
    if not stack1 and not stack2:
        return 1
        
    return 0