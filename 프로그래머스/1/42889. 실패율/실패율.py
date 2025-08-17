def solution(N, stages):
    # 스테이지별 도전자 수를 구함
    challenge_count = [0] * (N + 2)
    for stage in stages:
        challenge_count[stage] += 1

    # 스테이지별 실패율 계산
    fail_rates = []
    total_users = len(stages)

    for i in range(1, N + 1):
        if total_users == 0:
            # 도달한 유저가 없는 경우 실패율은 0
            fail_rate = 0
        else:
            # 실패율 = 현재 스테이지에 멈춰있는 사용자 수 / 현재 스테이지에 도달한 사용자 수
            fail_rate = challenge_count[i] / total_users
        
        fail_rates.append((fail_rate, i))
        
        # 다음 스테이지의 도달 사용자 수를 갱신
        total_users -= challenge_count[i]

    # 실패율을 기준으로 내림차순 정렬, 실패율이 같으면 스테이지 번호 오름차순
    fail_rates.sort(key=lambda x: (-x[0], x[1]))

    # 정렬된 스테이지 번호만 추출하여 반환
    answer = [stage for rate, stage in fail_rates]

    return answer