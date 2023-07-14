def solution(babbling):
    answer = 0
    # 발음 가능한 옹알이 케이스 모음
    babbles = ["aya", "ye", "woo", "ma"]
    """
    1. 각 문자열마다 슬라이딩 윈도우 이용하여 처음부터 문자열이 발음 가능한 옹알이로만 구성되었나 체크
    """
    
    
#     for babble in babbling:
#         cand = []
#         if babble in babbles:
#             answer += 1
#         else:
#             left = 0
#             right = 1
            
#             while right <= len(babble) and left <= right :
#                 if babble[left:right] in babbles:
#                     cand.append(babble[left:right])
#                     left = right
#                     right = left + 1
#                 else:
#                     right += 1
        
#             check = ''
#             for can in cand:
#                 check += can
#             if check == babble:
#                 answer += 1
                
    """
    2. 각 문자열을 순회하며 문자열에 모든 발음 가능한 문자열마다 replace를 적용
    """
    
    for bab in babbling:
        for babble in babbles:
            bab = bab.replace(babble, "0")
        if bab.isdigit():
            answer += 1
    return answer