import math

def solution(maps):    
    return bfs(maps)


def bfs(maps):
    n = len(maps)
    m = len(maps[0])
    queue = [[0, 0]]    
    visited = set([(0, 0)])    
    distances = {(0, 0):1}
    
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    while queue:
        cr, cc = queue.pop(0)
        
        if cr == n - 1 and cc == m - 1:
            return distances[(cr, cc)]
        
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]
            if 0 <= nr < n and 0 <= nc < m and maps[nr][nc] == 1 and (nr, nc) not in visited:            
                visited.add((nr, nc))
                distances[(nr, nc)] = distances[(cr, cc)] + 1
                queue.append([nr, nc])            
    
    return -1
    
                