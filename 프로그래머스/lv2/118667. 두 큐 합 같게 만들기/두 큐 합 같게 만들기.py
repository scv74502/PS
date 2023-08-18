from collections import deque


def solution(queue1, queue2):
    answer = 0
    
    limit = len(queue1) + len(queue2)
    
    q1s = sum(queue1)
    q2s= sum(queue2)   
    
    queue1 = deque(queue1)
    queue2 = deque(queue2)

    
    if (sum(queue1) + sum(queue2)) % 2 == 1:
        return -1
    
    
    while q1s != q2s:
        if answer >= limit:
            return -1
        while queue2 and q1s < q2s:
            tmp = queue2.popleft()
            queue1.append(tmp)
            q2s -= tmp
            q1s += tmp
            answer += 1
            
        while queue1 and q1s > q2s:
            tmp = queue1.popleft()
            queue2.append(tmp)
            q1s -= tmp
            q2s += tmp
            answer += 1
            
    return answer