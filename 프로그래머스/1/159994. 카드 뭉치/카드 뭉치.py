from collections import deque

def solution(cards1, cards2, goal):
    idx = 0
    goal_len = len(goal)
    
    cards1 = deque(cards1)
    cards2 = deque(cards2)
    
    while idx < goal_len:
        if cards1 and cards1[0] == goal[idx]:
            idx += 1
            cards1.popleft()
        elif cards2 and cards2[0] == goal[idx]:
            idx += 1
            cards2.popleft()
        else:
            return "No"
        
    return "Yes"