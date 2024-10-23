from collections import deque


def bfs(start_r, start_c, end_r, end_c, maps):
    row = len(maps)
    col = len(maps[0])
    visited = [[False for _ in range(col)] for __ in range(row)]
    
    # 상 하 좌 우
    mr = [-1, 1, 0, 0]
    mc = [0, 0, -1, 1]
    
    dq = deque()
    dq.append([start_r, start_c, 0])
    visited[start_r][start_c] = True
    
    while dq:
        cr, cc, cd = dq.popleft()
        if cr == end_r and cc == end_c:
            return cd
        
        for mv in range(4):
            nr, nc = cr + mr[mv], cc + mc[mv]
            if nr < 0 or row <= nr or nc < 0 or col <= nc:
                continue
            if maps[nr][nc] != 'X' and not visited[nr][nc]:
                visited[nr][nc] = True
                dq.append([nr, nc, cd + 1])
    return -1

def solution(maps):
    answer = 0
    row = len(maps)
    col = len(maps[0])
    startRow, startCol, leverRow, leverCol, endRow, endCol = 0, 0, 0, 0, 0, 0
    
    for i in range(0, row):
        for j in range(0, col):
            if maps[i][j] == 'S':
                startRow, startCol = i, j
            if maps[i][j] == 'L':
                leverRow, leverCol = i, j
            if maps[i][j] == 'E':
                endRow, endCol = i, j
    # print(startRow, startCol, leverRow, leverCol, endRow, endCol)
    
    answer = bfs(startRow, startCol, leverRow, leverCol, maps)
    # print(answer)
    if answer > -1:        
        temp = bfs(leverRow, leverCol, endRow, endCol, maps)    
        if temp > -1:
            answer += temp
        else:
            answer = temp
    return answer
            
                
    
    return answer