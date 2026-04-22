def solution(s):
    if len(s) == 1: return 1
    answer = 1000
    
    for step in range(1, len(s) // 2 + 1):
        count = 1
        prev = s[0:step]
        compressed = ""
        
        for i in range(step, len(s), step):
            if prev == s[i: i + step]:
                count += 1
            else:
                compressed += (str(count) if count > 1 else "") + prev
                count = 1
                prev = s[i: i + step]
                
        compressed += (str(count) if count > 1 else "") + prev
        answer = min(answer, len(compressed))
    
    return answer