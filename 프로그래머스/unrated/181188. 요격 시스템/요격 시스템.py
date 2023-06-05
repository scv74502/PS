def solution(targets):
    targets.sort()
    idx = 0
    answer = 0
    
    # print(targets[0][1]-1)
    
    # 정렬된 첫 타겟을 꺼내서 요격 사거리 내에 넣음
    idx = targets[0][1] - 1
    
    # 요격 사거리에 들어간 첫 타겟을 삭제하기
    targets.pop(0)
    
    # 미사일 한 발을 사용함
    answer += 1
    
    # print(targets)
    
    for target in targets:
        
        # print(idx)
        # print(target)
        
        # 현재 위치가 타겟의 요격 최대 범위 안이라면
        if idx > target[0]-1:
            # 현재 위치를 현위치, 타깃 요격 가능한 최대 범위 중 작은 것으로
            idx = min(idx, target[1]-1)
        # 현재 위치가 타겟의 요격 최소 범위에 미달한다면
        else:
            idx = target[1]-1
            answer += 1
        
    return answer