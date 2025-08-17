from collections import deque

def solution(numbers, direction):
    dq = deque(numbers)
    
    if direction == "left":
        dq.append(dq.popleft())
    else:
        dq.appendleft(dq.pop())
    
    answer = list(dq)
    return answer