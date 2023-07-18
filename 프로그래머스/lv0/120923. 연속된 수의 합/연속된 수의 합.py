"""
타겟이 되는 숫자의 리스트 범위를 충분히 크게 설정해야 한다
ex)num이 0이고 total이 6인 경우
"""


def solution(num, total):
    tgt = [i for i in range(-1000, 1001)]
    idx = 0
    print(sum(tgt[0:num]))
    
    while True:
        if sum(tgt[idx:idx+num]) == total:
            return tgt[idx:idx+num]
        elif sum(tgt[idx:idx+num]) < total:
            idx += 1
        else:
            idx -= 1