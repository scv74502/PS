def solution(targets):
    targets.sort()
    # print(targets)
    missiles = 0
    
    # 시작 지점은 정렬된 타깃 죄표의 맨 오른쪽에서 1을 뺀 부분으로 설정(맨 오른쪽 자체는 요격 불가)
    origin = targets[0][1] - 1
    missiles += 1
    targets.pop(0)

    for target in targets:
        if origin > target[0]-1:
            origin = min(origin,target[1]-1)
        else:
            missiles += 1
            origin = target[1]-1
    return missiles