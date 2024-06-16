def solution(targets):
    # s, s가 같으면 e 순으로 정렬하기
    targets.sort()

    # 초기에는 무조건 미사일 하나 소비함
    answer = 1
    # 현재 미사일이 있는 좌표 초기화
    idx = targets[0][1] - 1

    for target in targets:
        if target[0] - 1 < idx:
            idx = min(idx, target[1] - 1)
        else:
            answer += 1
            idx = target[1] - 1

    return answer