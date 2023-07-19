"""
문제 해결 접근방법
1. 시작점으로부터 레버 점으로까지 최단 거리 구함
2. 레버로부터 출구로까지 최단 거리 구함
3. 이 둘을 더하여 반환. 1, 2에서 접근 불가능하면 -1 반환하고 종료
4. visited 배열을 3차원으로 만들어 시작-레버, 레버-출구 방문 배열 만들기
"""


from collections import deque

dirs = ((-1, 0), (1, 0),(0, -1), (0, 1))
INF = float('inf')


def solution(maps):
    
    MAX_R = len(maps)
    MAX_C = len(maps[0])
    
    def bfs(start, end):
        dq = deque()
        # 시작점으로부터 각 지도의 거리 저장하는 배열
        dist_maps = [[INF] * MAX_C for _ in range(MAX_R)]
        dist_maps[start[0]][start[1]] = 0
        dq.append([start[0], start[1], 0])
        
        while dq:
            cur_r, cur_c, cur_d = dq.popleft()
            
            if cur_r == end[0] and cur_c == end[1]:
                return cur_d
            
            for dir in dirs:
                nr, nc, nd = cur_r + dir[0], cur_c + dir[1], cur_d + 1
                if 0 <= nr < MAX_R and 0 <= nc < MAX_C and maps[nr][nc] != "X" and nd < dist_maps[nr][nc]:
                    dist_maps[nr][nc] = nd
                    dq.append([nr, nc, nd])
        
        return -1
    
    start, lever, end = [0, 0], [0, 0], [0, 0]
    for r in range(MAX_R):
        for c in range(MAX_C):
            if maps[r][c] == "S":
                start = [r, c]
            elif maps[r][c] == "L":
                lever = [r, c]
            elif maps[r][c] == "E":
                end = [r, c]
    
    start_to_lever = bfs(start, lever)
    lever_to_end = bfs(lever, end)
    
    if start_to_lever == -1 or lever_to_end == -1:
        return -1
    else:
        return start_to_lever + lever_to_end
        
    
        
    
    