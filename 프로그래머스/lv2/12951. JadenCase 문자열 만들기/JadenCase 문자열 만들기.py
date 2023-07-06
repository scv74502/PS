def solution(s):
    # 전체 문자열을 소문자로
    splited = list(s.lower())
    
    # 맨 첫 글자가 알파벳이면 대문자로
    if splited[0].isalpha():
        splited[0] = splited[0].upper()
    
    # 두 번째 글자부터 검사하면서, 공백 다음 처음으로 오는 알파벳이면 대문자로 바꾸기
    for i in range(1, len(splited)):
        if splited[i-1] == " " and splited[i].isalpha():
            splited[i] = splited[i].upper()
    
    # 리스트를 문자열로 바꾸기
    answer =  "".join(splited)
    
    return answer