def solution(k, score):
    hall = []
    answer = []
    for num in score:
        if len(hall) < k:
            hall.append(num)
            hall.sort()
        else:
            
            if num >= hall[0]:
                hall[0] = num
            hall.sort()
        answer.append(hall[0])
        #print(answer)
    return answer