def solution(board, moves):
    n = len(board)
    stack = [[] for _ in range(n)]
    
    for i in range(n-1, -1, -1):
        line = board[i]
        for i, num in enumerate(line):
            if num == 0:
                continue
            stack[i].append(num)
    
    basket = []
    answer = 0
    
    for move in moves:
        cur_idx = move - 1
        if not stack[cur_idx]:
            continue
        elif basket and stack[cur_idx][-1] == basket[-1]:
            stack[cur_idx].pop()
            basket.pop()
            answer += 2
        else:
            basket.append(stack[cur_idx].pop())
    
    
    return answer