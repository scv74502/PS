def solution(s):
    splited = list(s.lower())
    if splited[0].isalpha():
        splited[0] = splited[0].upper()
    
    for i in range(1, len(splited)):
        if splited[i-1] == " " and splited[i].isalpha():
            splited[i] = splited[i].upper()
    
    
    return "".join(splited)