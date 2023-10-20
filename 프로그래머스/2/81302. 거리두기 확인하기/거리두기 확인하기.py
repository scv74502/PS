from collections import deque


def solution(places):
    answer = []
    
    # 상 하 좌 우
    mx = [0, 0, -1, 1]
    my = [1, -1, 0, 0]
    
    # 두 교육생 정보 입력받아 거리 체크하고, 맨하탄 거리 2 이하면 파티션 체크하기
    def check_partition(sx, sy, dx, dy, room):
        visited = [[False for _ in range(len(room))] for __ in range(len(room))]
        visited[sx][sy] = True            
        dq = deque()
        dq.append([sx, sy, False, 0])
            
        while dq:
            cx, cy, pfound, moved = dq.popleft()
            
            
            if cx == dx and cy == dy and moved == 2:
                if not pfound:
                    #print(f"not pfound, cx : {cx}, cy : {cy}")
                    return False
                    break
            
    
            for m in range(4):
                visited[dy][dx] = False
                nx, ny = cx + mx[m], cy + my[m]
                if 0 <= nx < len(room) and 0 <= ny < len(room) and not visited[ny][nx]:
                    visited[ny][nx] = True
                    if room[ny][nx] == 'X' or pfound:
                        dq.append([nx, ny, True, moved+1])
                    else:
                        dq.append([nx, ny, False, moved+1])
        
        return True
    
    
    # 고사장을 받아서 정보 체크하기
    def check_distanced(room):
        people = []
        for i in range(len(room)):
            for j in range(len(room)):
                if room[j][i] == 'P':
                    people.append([i, j])
        # print(people)
        
        for i in range(0, len(people)-1):
            for j in range(i+1, len(people)):
                x1, y1, x2, y2 = people[i][0], people[i][1], people[j][0], people[j][1]
                dist = abs(x2 - x1) + abs(y2 - y1)
                if dist < 2:
                    return False
                elif dist == 2:
                    if x1 == x2 and room[min(y1, y2)+1][x1] != 'X':
                        return False
                    elif y1 == y2 and room[y1][min(x1, x2)+1] != 'X':
                        return False
                    else:                        
                        if not check_partition(x1, y1, x2, y2, room):
                            return False
        #print("distanced checked, True")
        return True
        
    
    for place in places:
        if check_distanced(place):
            answer.append(1)
        else:
            answer.append(0)
    return answer