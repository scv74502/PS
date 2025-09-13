from collections import deque

def solution(maps):
    answer = 0
    N, M = len(maps), len(maps[0])
    start_r, start_c, lever_r, lever_c, end_r, end_c = 0, 0, 0, 0, 0, 0
    for i in range(N):
        for j in range(M):
            if maps[i][j] == "S":
                start_r, start_c = i, j
            elif maps[i][j] == "L":
                lever_r, lever_c = i, j
            elif maps[i][j] == "E":
                end_r, end_c = i, j
    
    start_to_lever = bfs(start_r, start_c, lever_r, lever_c, maps)
    # print(start_to_lever)
    if start_to_lever == -1:
        return -1
    
    lever_to_end = bfs(lever_r, lever_c, end_r, end_c, maps)
    # print(lever_to_end)
    if lever_to_end == -1:
        return -1
    
    return start_to_lever + lever_to_end

def bfs(start_r, start_c, end_r, end_c, maps):
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    N, M = len(maps), len(maps[0])
    visited = [[False for _ in range(M)] for __ in range(N)]
    dq = deque()
    dq.append([start_r, start_c, 0])
    visited[start_r][start_c] = True
    
    while dq:
        cr, cc, cd = dq.popleft()
        # print(cr, cc, cd)
        if cr == end_r and cc == end_c:
            return cd
        
        for i in range(4):
            nr, nc = cr + dr[i], cc + dc[i]
            if not (0 <= nr < N) or not (0 <= nc < M) or visited[nr][nc] or maps[nr][nc] == "X":
                continue
            dq.append([nr, nc, cd + 1])
            visited[nr][nc] = True
        
    return -1
    