"""
1. Counter 모듈 통해 누적합 구하기
2. 처음엔 한 쪽이 모두 갖고 있다고 가정하고, 누적합 수 관리하며 0이 되면 del 통해 삭제하기
"""
from collections import Counter


def solution(topping):
    answer = 0
    bro = Counter(topping)
    chul = set()
    print(bro)
    
    for i in topping:
        bro[i] -= 1
        if bro[i] == 0:
            del bro[i]
        chul.add(i)
        if len(bro) == len(chul):
            answer += 1
    

    return answer