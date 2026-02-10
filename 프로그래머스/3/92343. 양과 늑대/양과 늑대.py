import sys
from collections import deque


def solution(info, edges):    
    max_sheep = 0
    
    graph = [[] for __ in range(len(info))]
    for edge in edges:
        graph[edge[0]].append(edge[1])
        
    dq = deque()
    dq.append([0, 1, 0, set()])
    
    while dq:
        loc, sheep, wolf, visited = dq.popleft()
        visited.update(graph[loc])
        max_sheep = max(max_sheep, sheep)
        
        for next_loc in visited:
            if info[next_loc] == 0:
                dq.append([next_loc, sheep + 1, wolf, visited - {next_loc}])
            else:
                if sheep > wolf + 1:
                    dq.append([next_loc, sheep, wolf + 1, visited - {next_loc}])
    
    return max_sheep