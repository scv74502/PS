def solution(n, w, num):
    floor = n // w
    if floor == 0 or n % floor != 0:
        floor += 1
    
    warehouse = [[-1 for __ in range(w)] for _ in range(floor)]
    start_num = 1
    for i in range(0, floor):
        if (i + 1) % 2 == 1:
            start, end, increment = 0, w, 1
        else:
            start, end, increment = w-1, -1, -1
        
        for j in range(start, end, increment):
            if start_num > n:
                break
                
            warehouse[i][j] = start_num
            if start_num == num:
                tgt_w, tgt_h = j, i
            
            start_num += 1
        
        if start_num > n:
            break
            
    # print(warehouse)
    answer = 1
    
    for i in range(floor - 1, tgt_h, -1):
        if warehouse[i][tgt_w] == -1:
            continue
        answer += 1
    
    return answer