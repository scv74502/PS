from collections import defaultdict

def solution(players, callings):
    player_idx = defaultdict(str)
    
    for i, player in enumerate(players):
        player_idx[player] = i
        
    # calling 처리
    for call in callings:
        # 현재 선수 위치와 추월당하는 선수 위치
        cur = player_idx[call]
        behind = cur - 1
        
        bname = players[behind]
        player_idx[call], player_idx[bname] = player_idx[bname], player_idx[call]
    
        players[cur], players[behind] = players[behind], players[cur]
        
    
    return players