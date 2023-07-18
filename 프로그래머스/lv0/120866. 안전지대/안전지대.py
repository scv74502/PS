def solution(board):
    answer = 0
    move = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [1, 1], [-1, 1], [1, -1]]
    
    n = len(board)
    
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                for mv in move:
                    ni = i + mv[0]
                    nj = j + mv[1]
                    if 0 <= ni < n and 0 <= nj < n and board[ni][nj] != 1:
                        board[ni][nj] = 2
    
    print(board)
    
    for row in board:
        answer += row.count(0)
    
    return answer