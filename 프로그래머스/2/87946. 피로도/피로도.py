def solution(k, dungeons):
    n = len(dungeons)
    visited = [False for _ in range(n)]
    answer = bt(k, dungeons, visited, 0, 0)
    return answer

def bt(health, dungeons, visited, depth, cnt):
    """
    남은 피로도, 던전 배열, 방문 여부, 탐색 깊이, 탐험한 던전 개수
    """
    
    # 종료 조건 - 모든 던전 탐색했을 때
    if depth == len(dungeons):
        return cnt
    
    max_cnt = cnt  # 현재 cnt를 최댓값으로 초기화
    
    for i in range(len(dungeons)):
        if visited[i]:
            continue
        
        visited[i] = True
        
        health_cutline = dungeons[i][0]
        health_cost = dungeons[i][1]
        
        # 현재 던전 탐험 가능한 체력이면 탐험함
        if health >= health_cutline:
            result = bt(health - health_cost, dungeons, visited, depth + 1, cnt + 1)
            max_cnt = max(max_cnt, result)        
            # 현재 던전 탐험하지 않는 경우
            result = bt(health, dungeons, visited, depth + 1, cnt)
            max_cnt = max(max_cnt, result)
        
        visited[i] = False
    
    return max_cnt