def solution(sequence, k):
    left = 0
    seq_sum = 0
    answer = []
    
    # print(sum(sequence[left:right+1]))
    for right in range(0, len(sequence)):
        seq_sum += sequence[right]
        if seq_sum == k:
            answer.append([left, right])
        

        while seq_sum > k:
            seq_sum -= sequence[left]
            left += 1
            if seq_sum == k:
                answer.append([left, right])
    
    # print(answer)     
    if len(answer) == 1:
        return answer[0]
    else:
        answer.sort(key = lambda x: x[1] - x[0])
        return answer[0]