# 상:0, 좌:1, 우:2
my = [-1, 0, 0]
mx = [0, -1, 1]


for t_num in range(1, 11):
    tc = int(input())
    ladder = [list(map(int, input().split())) for _ in range(100)]
    cx = ladder[99].index(2)
    cy = 99
    course = 0  # 방향
    
    while cy > 0:
        # 좌로 가는 경우-왼쪽으로 이동 가능한 사다리가 있으며 현재 방향이 위나 좌로 가는 중 + 사다리 안 벗어남
        if cx > 0 and ladder[cy][cx-1] == 1 and course != 2:
            course = 1
        # 우로 가는 경우-오른쪽으로 이동 가능한 사다리가 있으며 현재 방향이 위나 우로 가는 중 + 사다리 안 벗어남
        elif cx < 99 and ladder[cy][cx+1] == 1 and course != 1:
            course = 2
        # 위로 이동하는 경우 - 좌로 이동중 좌가 없거나 막혔음, 우로 이동하는 중 우가 없거나 막혔음, 위로 이동하는 중인데 위에 이동 가능함
        elif (course == 1 and (cx == 0 or ladder[cy][cx-1] == 0)) or (course == 2 and (cx == 99 or ladder[cy][cx+1] == 0)) or (course == 0 and ladder[cy-1][cx] == 1):
            course = 0

        cy, cx = cy + my[course], cx + mx[course]
        # print(cy, cx)

    print(f"#{tc} {cx}")

    
