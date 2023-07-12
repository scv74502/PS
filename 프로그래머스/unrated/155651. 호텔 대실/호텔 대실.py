"""
알고리즘 : imos 알고리즘
링크 : https://velog.io/@nkrang/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-imos-%EB%B2%95
"""
CLEAR_TIME = 10


def time_to_min(time):
    time_min = list(time.split(":"))
    return int(time_min[0]) * 60 + int(time_min[1])


def solution(book_time):
    imos = [0 for _ in range(0, 24*60+10)]
    
    for start, end in book_time:
        start_min = time_to_min(start)
        end_min = time_to_min(end)
    
        imos[start_min] += 1
        imos[end_min + CLEAR_TIME] -= 1

    answer = 0
    # 누적합
    cumulative_sum = 0
    
    for i in range(0, 24*60):
        cumulative_sum += imos[i]
        answer = max(answer, cumulative_sum)
    
    return answer
        
    
    
