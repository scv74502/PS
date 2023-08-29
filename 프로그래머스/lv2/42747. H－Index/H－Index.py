"""
1. 발표논문 n개 중에서 (h번 이상 인용된 논문의 개수 h)를 구한다
(1 <= n <= 1000, 0 <= h <= 10000)

2. 완전 탐색으로 풀기, 인용 횟수가 최소 0이고 최대 발표 논문 갯수만큼 나옴
=> 논문 갯수부터 0까지 범위에서 h값을 찾으면 최대 h값 찾을 수 있음

3. 이 예상 h값에 대하여 인용 목록 모든 논문에 대하여 인용 횟수 체크한 다음, 인용 횟수가 예상 h값 이상이면 반환(종료)
=> 내림차순이므로 최대 h값임이 보장됨
"""


def solution(citations):
    cits = citations
    
    for cit in range(len(cits), -1, -1):
        refered = 0
        # com은 compare, 비교하려는 인용 목록에서 하나의 인용값을 의미함
        for com in cits:
            # 인용 값이 현재 예상 h값 이상이면
            if com >= cit:
                # 인용된 논문 카운트 값 증가
                refered += 1
        # 인용된 논문 카운트 값이 현재 예상 h값보다 크다면, 값 반환
        if refered >= cit:
            return cit