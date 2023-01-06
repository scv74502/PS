def solution(s):
    # 문자열을 리스트로
    SL = list(s)
    answer = 0
    # 지정 문자, 같은 문자, 다른 문자
    CntL = ["", 1, 0]
    index = 1
    
    while len(SL) > 0:
        if len(SL) == index:
            answer += 1
            break
        CntL[0] = SL[0]
        if CntL[0] == SL[index]:
            CntL[1] += 1
            index += 1
        else:
            CntL[2] += 1
            if CntL[1] == CntL[2]:
                del SL[:index+1]
                answer += 1
                index, CntL[1], CntL[2] = 1, 1, 0
            else:
                index += 1
    return answer