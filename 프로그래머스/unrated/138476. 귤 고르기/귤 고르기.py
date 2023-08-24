def solution(k, tangerine):
    types = set(tangerine)
    tan_dict = dict()
    for type in types:
        tan_dict[type] = 0
    answer = 0
    
    for tan in tangerine:
        tan_dict[tan] += 1
    
    res = list(tan_dict.items())
    res.sort(key = lambda x:-x[1])
    cnt = 0
    for tan in res:
        cnt += tan[1]
        answer += 1
        if cnt >= k:
            return answer
            
        
        
    return answer