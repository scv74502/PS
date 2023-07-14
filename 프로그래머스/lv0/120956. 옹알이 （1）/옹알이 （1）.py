def solution(babbling):
    answer = 0
    babbles = ["aya", "ye", "woo", "ma"]
    
    for babble in babbling:
        cand = []
        if babble in babbles:
            answer += 1
        else:
            left = 0
            right = 1
            
            while right <= len(babble) and left <= right :
                if babble[left:right] in babbles:
                    cand.append(babble[left:right])
                    left = right
                    right = left + 1
                else:
                    right += 1
        
            check = ''
            for can in cand:
                check += can
            if check == babble:
                answer += 1
                
                    
                
    return answer