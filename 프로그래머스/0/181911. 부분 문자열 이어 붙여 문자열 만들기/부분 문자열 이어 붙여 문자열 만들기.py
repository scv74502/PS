def solution(my_strings, parts):
    answer = ''
    
    for i in range(0, len(parts)):
        l, r = parts[i]
        answer += my_strings[i][l:r+1]
    return answer