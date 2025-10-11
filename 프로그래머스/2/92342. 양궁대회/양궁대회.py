def solution(n, info):
    max_diff = 0
    best_result = [-1]
    
    def bt(apeach, arrows_left, lion, idx):
        nonlocal max_diff, best_result
        
        # 모든 화살을 다 쐈거나 모든 점수를 확인한 경우
        if arrows_left == 0 or idx == 11:
            # 남은 화살은 0점에 모두 쏘기
            if arrows_left > 0:
                lion[10] = arrows_left
            
            # 점수 계산
            apeach_score, lion_score = 0, 0
            for i in range(11):
                if apeach[i] == 0 and lion[i] == 0:
                    continue
                if lion[i] > apeach[i]:
                    lion_score += (10 - i)
                else:
                    apeach_score += (10 - i)
            
            diff = lion_score - apeach_score
            
            # 더 큰 차이로 이기는 경우
            if diff > max_diff:
                max_diff = diff
                best_result = lion[:]
            # 같은 차이인 경우 낮은 점수를 더 많이 맞힌 경우
            elif diff > 0 and diff == max_diff:
                if is_better(lion, best_result):
                    best_result = lion[:]
            
            # 백트래킹 준비
            if arrows_left > 0:
                lion[10] = 0
            return
        
        # 현재 점수를 이기는 경우 (어피치보다 1발 더 쏘기)
        need = apeach[idx] + 1
        if arrows_left >= need:
            lion[idx] = need
            bt(apeach, arrows_left - need, lion, idx + 1)
            lion[idx] = 0
        
        # 현재 점수를 포기하는 경우
        bt(apeach, arrows_left, lion, idx + 1)
    
    def is_better(new, old):
        # 낮은 점수를 더 많이 맞힌 것이 유리
        for i in range(10, -1, -1):
            if new[i] > old[i]:
                return True
            elif new[i] < old[i]:
                return False
        return False
    
    lion = [0] * 11
    bt(info, n, lion, 0)
    
    return best_result