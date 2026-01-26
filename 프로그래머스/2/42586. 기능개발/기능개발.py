import math

def solution(progresses, speeds):
    n = len(progresses)
    left_day = [math.ceil((100 - progresses[i]) / speeds[i]) for i in range(n)]  # 올림 연산
    answer = []
    
    longest_day = left_day[0]
    count = 0
    
    for i in range(n):        
        if longest_day >= left_day[i]:
            count += 1
        else:
            answer.append(count)
            count = 1
            longest_day = left_day[i] 
    
    answer.append(count)    
    return answer