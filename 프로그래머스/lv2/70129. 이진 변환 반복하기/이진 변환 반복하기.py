def solution(s):
    deleted_zero = 0
    cnt = 0
    answer = []
    while True:
        if s == "1":
            break
            
        # 이진 변환 횟수 추가
        cnt += 1
        deleted_zero += s.count("0")
        s = ''.join([string for string in s if string != "0"])
        s = format(len(s), 'b')
        print(s)
        # 검사하기
        
        
    
    return [cnt, deleted_zero]