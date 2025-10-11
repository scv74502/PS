from collections import deque


def solution(n, wires):
    answer = n
    
    graph = [[False for _ in range(n+1)] for __ in range(n+1)]
    # 그래프 선 연결
    for u, v in wires:
        graph[u][v] = True
        graph[v][u] = True
    
    for u, v in wires:
        graph[u][v] = False
        graph[v][u] = False
        
        answer = min(answer, search(n, graph))
        
        graph[u][v] = True
        graph[v][u] = True
    
    return answer


def search(n, graph):
    visited = [False for _ in range(n+1)]
    results = []
    for i in range(1, n+1):
        if visited[i]:
            continue
        result = bfs(i, graph, visited)
        results.append(result)
        
    return abs(results[0] - results[1])

def bfs(vertex, graph, visited):
    n = len(graph) - 1
    visited[vertex] = True
    answer = 1
    
    dq = deque()
    dq.append(vertex)
    
    while dq:
        cur_vertex = dq.pop()
        for i in range(1, n+1):
            if i == cur_vertex or not graph[cur_vertex][i] or visited[i]:
                continue
            dq.append(i)
            visited[i] = True
            answer += 1
    
    return answer
    
    