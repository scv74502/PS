def solution(plans):
    # 현재 진행중인 작업 포인터
    current = 0
    
    # 진행중이던 작업들 저장용 
    ongoing_queue = []
    
    # playtime 총합
    playtime = 0
    
    # 시간을 정수 분단위로 통일
    for plan in plans:
        plan[1] = list(plan[1].split(":"))
        plan[1] = int(plan[1][0]) * 60 + int(plan[1][1])
        plan[2] = int(plan[2])
        
        # playtime 총합 구하기
        playtime += plan[2]
        
    # 과제 목록을 시작 시간 순으로 정렬하기
    plans.sort(key=lambda x: x[1])
    
    # 정답 저장 배열
    answer = []
    
    stack = []
    
    for i in range(len(plans)):
        if i == len(plans)-1:
            stack.append(plans[i])
            break
        
        subject, start, time = plans[i]
        nsubject, nstart, ntime = plans[i+1]
        
        if start + time <= nstart:
            answer.append(subject)
            temp_time = nstart - (start + time)
            
            while temp_time != 0 and stack:
                tsubject, tstart, ttime = stack.pop()
                if temp_time >= ttime:
                    answer.append(tsubject)
                    temp_time -= ttime
                else:
                    stack.append([tsubject, tstart, ttime - temp_time])
                    temp_time = 0
        else:
            plans[i][2] = time - (nstart - start)
            stack.append(plans[i])
    
    while stack:
        subject, start, ttime = stack.pop()
        answer.append(subject)
    
    return answer