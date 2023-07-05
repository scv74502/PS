from collections import *


def solution(board):
    
    # 행, 열 길이
    N = len(board)
    M = len(board[0])
    # print(row_len, col_len)
    
    # 상하좌우 - 각각 가로와 세로
    dy = [0, 0, 1, -1]
    dx = [-1, 1, 0, 0]
    
    # 큐 생성하기
    queue = deque()
    
    dist = [[999999999 for _ in range(M)] for _ in range(N)]
    answer = 0
    print(dir(deque))
    
    # 맵을 전체 탐색하며 로봇이 존재하는 위치를 찾기
    for i in range(N):
        for j in range(M):
            if board[i][j] == 'R':
                queue.append((i, j, 0))
                dist[i][j] = 0
        if queue:
            break
    
    # 큐가 빌 때까지
    while queue:
        x, y, cnt = queue.popleft()
        
        # 목표 지점에 도착했다면 리턴 후 종료하기
        if board[x][y] == 'G':
            return cnt
        
        
        # 4방향 탐색하는 bfs 탐색
        for d in range(4):
            nx = x
            ny = y
            
            while 0 <= nx + dx[d] < N and 0 <= ny + dy[d] < M and board[nx + dx[d]][ny + dy[d]] != 'D':
                nx += dx[d]
                ny += dy[d]
            
            if dist[nx][ny] > cnt+1:
                dist[nx][ny] = cnt+1
                queue.append((nx, ny, cnt+1))
        
    return -1