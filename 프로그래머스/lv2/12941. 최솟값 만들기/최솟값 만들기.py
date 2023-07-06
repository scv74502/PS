"""
문제 접근방법
1. 큰 수가 적은 회수로 곱해져야 값의 총합이 적어진다는 원리로 접근하기
2. A의 큰 수들 * B의 작은 수들을 곱하는 방식으로 접근하면 총합은 최소화되지 않을까?
"""


def solution(A,B):
    answer = 0
    A.sort()
    B.sort(reverse=True)
    for num1, num2 in zip(A, B):
        print(num1, num2)
        answer += num1 * num2
    
    return answer