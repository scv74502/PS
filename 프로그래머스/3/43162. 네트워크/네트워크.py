def solution(n, computers):
    # 방문 여부 체크
    visited = [False for _ in range(n)]
    
    # 연결 여부 초기화
    graph = [[False for _ in range(n)] for __ in range(n)]
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                graph[i][j] = True
                
    queue = []
    answer = 0
    
    for i in range(n):
        if visited[i]:
            continue
        # print(i)
        answer += 1
        queue.append(i)
        visited[i] = True
        bfs(visited, graph, queue)
        # print(visited, graph, queue)
    
    
    return answer


def bfs(visited, graph, queue):
    n = len(graph)
    while queue:
        cur = queue.pop()
        
        for i in range(n):
            if not graph[cur][i] or visited[i]:
                continue
            queue.append(i)
            visited[i] = True
            