"""
알고리즘 : imos 알고리즘
링크 : https://velog.io/@nkrang/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-imos-%EB%B2%95

-방법-
1. 시간에 대한 일차원 배열 생성
2. 입장 시간에 +1, 퇴장 시간에 -1
3. 1번의 배열의 누적합 구하기

유사문제 : BOJ 3020 '개똥벌레'
"""
CLEAR_TIME_10 = 10


def time_to_min(time):
    time_min = time.split(":")
    return int(time_min[0]) * 60 + int(time_min[1])


def solution(book_time):
    imos = [0 for _ in range(0, 24*60+10)]
    
    for start, end in book_time:
        start_min = time_to_min(start)
        end_min = time_to_min(end)
    
        imos[start_min] += 1
        imos[end_min + CLEAR_TIME_10] -= 1

    answer = 0
    # 누적합
    cumulative_sum = 0
    
    for i in range(0, 24*60+10):
        cumulative_sum += imos[i]
        # 누적합과 현재 답 중에서 큰 값을 취함
        answer = max(answer, cumulative_sum)
    
    return answer