from collections import deque

def solution(s):
    s = deque(s)
    start = set(["[", "(", "{"])
    end = set(["]", ")", "}"])
    match = dict({")":"(", "]":"[", "}":"{"})
    stack = []
    cnt = 0
    
    while s:
        c = s.popleft()
        
        # 문자가 start 안에 있으면 스택에 추가함
        if c in start:
            stack.append(c)
            continue
        
        if stack and match[c] == stack.pop(): # end이면서 짝이 맞으면 pop하고 이어서 진행
            if not stack:   # 회전 필요한 괄호라면 cnt를 추가함
                cnt += 1
            continue
        
        if not stack:   # end인데 stack이 비었으면 뒤쪽 체크
            back = []
            while s:
                temp = s.pop()
                if match[c] == temp and not back:   # 짝이 맞으면 확인 종료함
                    break
                if temp in end: # end이면 back에 넣기
                    back.append(temp)
                elif back and temp == match[back.pop()]:    # start이면서 짝이 맞으면 pop하고 이어서 진행
                    continue
                else:   # 짝이 맞지 않으면 괄호 만들 수 없음
                    return 0
            else:
                return 0
            cnt = 1 # end가 먼저 나온 것을 해결했다면, 기존 괄호들은 전부 최외곽 괄호가 아니게 되므로 cnt가 1
            continue
        
        cnt = 0 # end이면서 pop해서 확인한 결과와 일치하지 않음
        break
    if stack:
        cnt = 0
    return cnt
                    
                    