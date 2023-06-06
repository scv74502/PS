def solution(targets):
    
    # 시작점을 기준으로 오름차순 정렬하기
    targets.sort()
    # print(targets)
    
    # 처음으로 정렬된 점을 뽑아서 설정하기
    idx = targets[0][1] - 1
    targets.pop(0)
    # 초기에 미사일 하나 소비함
    answer = 1
    
    for target in targets:
        # 정수값과 실수값 차이 감안해서, 현재 인덱스가 현 타겟의 요격 범위 내라면
        if idx > target[0]-1:
            # 인덱스를 현재 인덱스 값과 타깃의 최대 요격범위 직전 정수값 중 작은 것으로 설정
            idx = min(idx, target[1]-1)
        # 만약 현 인댁스가 타겟의 최소 요격 범위에 미달한다면
        else:
            idx = target[1] - 1
            answer += 1
            
    
    return answer