def solution(data, col, row_begin, row_end):
    data.sort(key=lambda x:(x[col-1], -x[0]))
    answer = 0
    
    S = []
    
    for i in range(row_begin, row_end+1):
        res = 0
        for num in data[i-1]:
            res += num % (i)
        S.append(res)
    # print(S)
    
    # xor 연산 연산자는 ^이다
    start = S[0]
    
    for i in range(1, len(S)):
        start = start ^ S[i]
        
    return start