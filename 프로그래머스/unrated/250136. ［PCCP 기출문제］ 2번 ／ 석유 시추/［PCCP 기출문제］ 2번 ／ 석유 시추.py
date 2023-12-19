"""
라인 체크하는 line_check의 [False] * W 배열 사용하고 순차 탐색하니 시간 초과
set()을 사용하니 시간 초과 발생하지 않고 통과함!
"""
from collections import deque

# 상, 하, 좌, 우
mh = [-1, 1, 0, 0]
mw = [0, 0, -1, 1]


def solution(land):
    answer = 0
    h, w = len(land), len(land[0])
    visited = [[False for _ in range(w)] for __ in range(h)]
    line_map = [0 for _ in range(w)]
    
    for i in range(h-1, -1, -1):
        for j in range(0, w):
            line_check = set()
            if not visited[i][j]:
                visited[i][j] = True
                
                if land[i][j] == 1:
                    oils = 0
                    dq = deque()
                    dq.append([i, j])
                    line_check.add(j)
                    
                    while dq:
                        oils += 1
                        ch, cw = dq.popleft()
                        visited[ch][cw] = True
                    
                        for m in range(4):
                            nh, nw = ch + mh[m], cw + mw[m]
                            
                            if 0 <= nh < h and 0 <= nw < w and not visited[nh][nw]:
                                visited[nh][nw] = True
                                if land[nh][nw] == 1:
                                    line_check.add(nw)
                                    dq.append([nh, nw])
                                    
                    # print(f"oils : {oils}")
                    for l in line_check:
                        # print(f"line_map[{l}] : {line_map[l]}, oils :{oils}")
                        line_map[l] += oils
                            
    return max(line_map)