import heapq
import math

def solution(N, road, K):
    # 거리 설정
    distances = [math.inf for _ in range(N + 1)]
    distances[1] = 0
    
    # 그래프 초기화
    graph = [[math.inf for _ in range(N+1)] for __ in range(N+1)]
    for i in range(1, N+1):
        graph[i][i] = 0
    
    # 그래프 입력, 두 정점 간 경로가 복수이므로 최소 거리 선택
    for u, v, dist in road:
        graph[u][v] = min(graph[u][v], dist)
        graph[v][u] = min(graph[v][u], dist)
    
    # 우선순위 큐, [거리, 정점]
    pq = []
    pq.append([0, 1])
    
    # 반복문 통해 빼기
    while pq:
        dist, vertex = heapq.heappop(pq)
        
        for i in range(1, N+1):
            # 현재 정점은 무시
            if i == vertex:
                continue
                
            dist_between_vertexes, next_vertex = graph[vertex][i], i
            
            # 연결되지 않았다면 무시
            if dist_between_vertexes == math.inf:
                continue
                
            next_dist = dist + dist_between_vertexes
            
            # 현재 거리 + 다음 거리가 현재 출발점부터 거리보다 멀면 무시
            if next_dist > distances[next_vertex]:
                continue

            distances[next_vertex] = next_dist
            heapq.heappush(pq, [next_dist, next_vertex])
    
    return len(list(filter(lambda x: x <= K, distances)))