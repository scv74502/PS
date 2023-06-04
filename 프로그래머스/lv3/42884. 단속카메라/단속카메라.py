def solution(routes):
    routes.sort()
    cameras = 0
    
    # 시작 지점은 맨 처음 경로의 맨 오른쪽
    idx = routes[0][1]
    routes.pop(0)
    cameras += 1
    
    for route in routes:
        if idx >= route[0]:
            idx = min(idx, route[1])
        else:
            cameras += 1
            idx = route[1]
    
    return cameras
        
    
                
        
    