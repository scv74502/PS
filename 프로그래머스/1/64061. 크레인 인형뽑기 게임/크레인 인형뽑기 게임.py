def solution(board, moves):
    N = len(board)
    moves = [move-1 for move in moves]
    basket = []
    answer = 0
    
    for move in moves:
        idx, cur = 0, 0
        
        while cur == 0 and idx < N:
            cur = board[idx][move]
            idx += 1
        
        # 맨 밑바닥까지 도달했는데도 아무것도 못 집으면 아무 일도 안 일어남
        if cur == 0:
            continue
        
        board[idx-1][move] = 0
        
        # print(basket, cur)
        
        if basket and cur == basket[-1]:
            basket.append(cur)
            for _ in range(2):
                answer += 1
                basket.pop()
        else:
            basket.append(cur)
        
        
    return answer