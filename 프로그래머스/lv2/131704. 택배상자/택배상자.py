def solution(order):
    # 각각 정렬된 짐과 트럭, 보조 컨테이너
    stock = sorted(order)
    truck = []
    temp_con = []
    
    # 트럭의 인덱스와 요구된 order의 짐 가리키는 인덱스
    t_idx = 0
    o_idx  = 0
    
    for i in range(len(order)):
        # 현재 stack의 들어온 짐이 order에서 필요한 짐이라면
        if stock[i] == order[o_idx]:
            # 트럭에 집어넣고, order의 다음 짐을 가리킴
            truck.append(order[o_idx])
            o_idx += 1
        # 현재 stack의 들어온 짐이 order에서 필요없는 짐이라면
        # 먼저 스택(보조 컨테이너)의 맨 위(최신)의 짐이 order가 요구한 짐이라면
        else:
            while True:
                if temp_con and temp_con[-1] == order[o_idx]:
                    truck.append(temp_con.pop())
                    o_idx += 1
                else:
                    break
            temp_con.append(stock[i])
    while True:
        if temp_con and temp_con[-1] == order[o_idx]:
            truck.append(temp_con.pop())
            o_idx += 1
        else:
            break
            
    
    return len(truck)
            
            
    
            
            
    
    answer = 0
    return answer