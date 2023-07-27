from collections import deque


mx = [1, -1, 0, 0]
my = [0, 0, -1, 1]


def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[False for i in range(m)] for _ in range(n)]
    answer = []
    
    def bfs(x, y):
        food = 0
        dq = deque()
        dq.append([x, y])
        visited[x][y] = True
        # print(dq)
        
        while dq:
            point = dq.pop()
            dx = point[0]
            dy = point[1]
            
            
            food += int(maps[dx][dy])
            # print(dx, dy)
            # print()
            
            for i in range(4):
                nx = dx + mx[i]
                ny = dy + my[i]
                # print("nx, ny : ", nx, ny)
                
                if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == False and maps[nx][ny] != "X":
                    # print("nx, ny : ", nx, ny)
                    # print()
                    dq.append([nx, ny])
                    visited[nx][ny] = True
                    
        print("bfs end")
        print()
        return food        
            
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] != "X" and visited[i][j] == False:
                answer.append(bfs(i, j))
            
    if answer:
        return sorted(answer)
    else:
        return [-1]