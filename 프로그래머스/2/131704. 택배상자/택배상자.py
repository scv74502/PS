from collections import deque


def solution(order):
    N = len(order)
    # 컨테이너 벨트는 큐 자료구조
    container = deque([i for i in range(1, N+1)], N)
    
    
    # 보조 컨테이너 벨트는 스택 자료구조
    stack = []
    
    # 트럭에 실린 짐
    truck = 0
    
    # 트럭이 idx번째 order의 짐을 실어야 함
    order_idx = 0
    
    # 1. order[order_idx] 찾을때까지 컨테이너의 짐을 stack에 삽입
    # 2. 짐 찾으면 트럭에 넣음
    # 3. 스택에서 짐 찾음
    
    # 컨테이너가 비었고, 보조컨테이너가 비지 않았으며 맨 위가 찾는 짐이 아니면 멈춤
    while True:    
        
        while container:
            num = container.popleft()
            if num == order[order_idx]:
                truck += 1
                order_idx += 1
                
                while stack and stack[-1] == order[order_idx]:
                    order_idx += 1
                    truck += 1
                    stack.pop()
            else:
                stack.append(num)
                
        if stack and stack[-1] == order[order_idx]:
            order_idx += 1
            truck += 1
            stack.pop()
                
        
        if (stack and stack[-1] != order[order_idx]) or truck == N:
            break
        
    return truck