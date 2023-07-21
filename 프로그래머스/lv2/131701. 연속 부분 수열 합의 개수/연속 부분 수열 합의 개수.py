"""
1. 완전 탐색 해결법
- 집합을 이용해서 중복된 부분 수열의 합을 ㅈ거
- 원형 수열이 n개면, 0번부터 n-1번 원소에 원소마다 1개부터 n개까지 수열을 체크
- 시간 복잡도는 n^2 정도로 추정됨, 연산 횟수도 많이 필요함
- dp로 개선할 필요가 있음
"""

def solution(elements):
    appeared = set()
    for i in range(1, len(elements)+1):
        for j in range(0, len(elements)):
            start = j
            end = start + i
            if end > len(elements):
                # print("end = ", end)
                # print(elements[start:], elements[:end-len(elements)])
                res = elements[start:] + elements[:end-len(elements)]
            else:
                # print(elements[start:end])
                res = elements[start:end]
            
            # print(res)
            appeared.add(sum(res))
                            
    # print(appeared)
    # for i in range(1, len(elements)+1):
    #     print(dp[i])
        # print(i)
    # test = [1, 2, 3, 4]
    # print(test[2:] + test[:2])
    
    return len(appeared)