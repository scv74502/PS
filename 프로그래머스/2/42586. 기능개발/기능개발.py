from collections import deque

def solution(progresses, speeds):
    N = len(progresses)
    
    progresses = deque(progresses)
    answer = []
    finished_job = 0
    finished_idx = 0
    cur_turn = 0
    
    while finished_job < N:
        cur_turn += 1
        finished_cur_turn = 0
        for i in range(N):
            cur_progress = progresses.popleft()                        
            if cur_progress >= 100 and i == finished_idx:
                finished_job += 1
                finished_idx += 1
                finished_cur_turn += 1
            else:
                cur_progress += speeds[i]
            progresses.append(cur_progress)
        
        if finished_cur_turn > 0:
            answer.append(finished_cur_turn)                            
    
    return answer