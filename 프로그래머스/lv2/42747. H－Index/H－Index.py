# 길이가 10000 이하이므로, 완전 탐색으로 풀어보려고 함
# 최악의 경우에는 모두 10000인 경우에는 10000, 즉 citations의 길이가 답이 될 수도 있음
# H-index는 h번 이상 인용된 논문이 h편 이상일 때, h값의 최대값이다


def solution(citations):
    c = citations
    for h in range(len(c),-1,-1):
        more = 0
        for compare in c:
            if compare >= h:
                more +=1
        # h번 이상 인용된 논문이 h편 이상이라면
        print(h, more)
        if more >= h:
            return h