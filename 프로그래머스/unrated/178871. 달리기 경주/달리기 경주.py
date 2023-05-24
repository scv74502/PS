def solution(players, callings):
    board_dict = dict()
    for i, player in enumerate(players):
        board_dict[player] = i
        
    for call in callings:
        pre, post = board_dict[call] - 1, board_dict[call]  # 추월 이전의 등수
        board_dict[players[pre]] = post # 이전에 앞선 등수 선수가 뒤의 등수로
        board_dict[players[post]] = pre # 이전에 뒤쳐지던 선수가 앞선 등수로
        players[pre], players[post] = players[post], players[pre]
        
        
    return players