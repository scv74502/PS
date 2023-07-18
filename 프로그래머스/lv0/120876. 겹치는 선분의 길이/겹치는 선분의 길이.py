def solution(lines):
    dots = [0 for _ in range(201)]
    
    for line in lines:
        start = line[0]
        end = line[1]
        
        for i in range(start+100, end+100):
            dots[i] += 1
    
    answer = 0
    for dot in dots:
        if dot > 1:
            answer += 1
    
    return answer