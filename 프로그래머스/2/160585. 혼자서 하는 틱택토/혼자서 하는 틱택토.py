def game_over(board, ch):
    # 가로, 세로
    for i in range(3):
        if board[i][0] == board[i][1] == board[i][2] == ch:
            return True
        if board[0][i] == board[1][i] == board[2][i] == ch:
            return True
    # 대각선
    if board[0][0] == board[1][1] == board[2][2] == ch:
        return True
    if board[0][2] == board[1][1] == board[2][0] == ch:
        return True
    return False


def solution(board):
    board_ch = [ch for line in board for ch in line]
    O_count = board_ch.count('O')
    X_count = board_ch.count('X')
    answer = 1

    # 선공이 O이므로 O가 있어야 함
    if(set(board_ch) == {'X'} or set(board_ch) == {'X', '.'}):
        answer = 0

    if O_count - X_count not in {0, 1}:
        answer = 0

    if(game_over(board, 'O')):
        if O_count - X_count != 1:
            answer = 0
        elif game_over(board, 'X'):
            answer = 0
    elif game_over(board, 'X'):
        if O_count - X_count != 0:
            answer = 0
    else:
        ("Not over")
    return answer