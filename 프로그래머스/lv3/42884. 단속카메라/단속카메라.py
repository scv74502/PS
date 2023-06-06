def solution(routes):
    # 진입점 기준으로 정렬
    routes.sort()  
    # 진입점부터 카메라가 차량 포착이 가능함, 진출점으로 카메라위치 설정
    idx = routes[0][1]
    # 포착했으므로 경로 배열에서 해당 경로를 제거하기
    routes.pop(0)
    # 우선 카메라 한 대가 필요하다
    camera = 1
    
    for route in routes:
        # print(idx)
        # 전 경로의 진출점이 현 경로의 진입점보다 앞쪽에 있다면(현위치에서 현 경로 포착 가능하다면)
        if idx >= route[0]:
            # 위치를 현 위치나 현 경로 진출점 중 더 좌측인 것으로 변경함
            idx = min(idx, route[1])
        # 전 경로의 진출점이 현 경로의 진입점보다 뒤쪽에 있다면(현 위치에서 현 경로 포착이 불가능하다면)
        else:
            # 카메라 설치함
            camera += 1
            # 현 위치를 현 경로의 진출점으로 변경함
            idx = route[1]

    return camera