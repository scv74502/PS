def solution(answers):
    arr1 = [1, 2, 3, 4, 5]
    arr2 = [2, 1, 2, 3, 2, 4, 2, 5]
    arr3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    len_arr1 = len(arr1)
    len_arr2 = len(arr2)
    len_arr3 = len(arr3)
    
    correct_cnt = [0, 0, 0]
    
    for i in range(len(answers)):
        cur_answer = answers[i]
        if cur_answer == arr1[i % len_arr1]:
            correct_cnt[0] += 1
        if cur_answer == arr2[i % len_arr2]:
            correct_cnt[1] += 1
        if cur_answer == arr3[i % len_arr3]:
            correct_cnt[2] += 1
    
    max_val = max(correct_cnt)
    answer = []
    
    for i in range(0, len(correct_cnt)):
        if correct_cnt[i] == max_val:
            answer.append(i + 1)
            
    answer.sort()
    return answer