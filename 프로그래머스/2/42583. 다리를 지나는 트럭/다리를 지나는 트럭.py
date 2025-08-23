from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge_weight = 0;
    bridge_stack = deque()
    
    for _ in range(bridge_length):
        bridge_stack.append(0)
    
    for truck in truck_weights:
        if bridge_weight + truck - bridge_stack[0] <= weight:
            bridge_stack.append(truck)
            bridge_weight += truck
            bridge_weight -= bridge_stack.popleft()
            # print("1 :", bridge_stack)
            answer += 1
        else:
            while bridge_weight + truck - bridge_stack[0] > weight:
                bridge_weight -= bridge_stack.popleft()
                bridge_stack.append(0)
                # print("2 :",bridge_stack)
                answer += 1
            bridge_stack.append(truck)
            bridge_weight += truck
            bridge_weight -= bridge_stack.popleft()
            # print("3 :",bridge_stack)
            answer += 1
        
    while bridge_weight > 0:
        # print("4 :",bridge_stack)
        answer += 1
        bridge_weight -= bridge_stack.popleft()
    
    return answer