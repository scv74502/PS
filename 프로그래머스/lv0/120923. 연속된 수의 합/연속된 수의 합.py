"""
타겟이 되는 숫자의 리스트 범위를 충분히 크게 설정해야 한다
ex)num이 0이고 total이 6인 경우

또한 가운데 값을 찾는 방식의 다른 풀이법이 있다
"""


def solution(num, total):
    """
    1. 반복문 사용하기
    """
#     tgt = [i for i in range(-1000, 1001)]
#     idx = 0
    
#     while True:
#         if sum(tgt[idx:idx+num]) == total:
#             return tgt[idx:idx+num]
#         elif sum(tgt[idx:idx+num]) < total:
#             idx += 1
#         else:
#             idx -= 1

    """
    2. 가운뎃 값 찾기
    """
    center = total // num
    start = center - (num - 1) // 2
    answer = [start+i for i in range(num)]
    return answer