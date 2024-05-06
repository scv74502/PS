import sys


# 위 오른쪽 아래 왼쪽
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
tc = int(sys.stdin.readline())
for _ in range(tc):
    # 상하, 좌우 좌표
    # 방향은 0, 1, 2, 3 순으로 위, 오른쪽, 아래, 왼쪽
    x, y, direction = 0, 0, 0
    set_x, set_y = set(), set()
    set_x.add(x)
    set_y.add(y)

    commands = sys.stdin.readline().strip()

    for command in commands:

        if command == 'F':
            if direction == 0:
                y += 1
            elif direction == 1:
                x += 1
            elif direction == 2:
                y -= 1
            elif direction == 3:
                x -= 1
        elif command == 'B':
            if direction == 0:
                y -= 1
            elif direction == 1:
                x -= 1
            elif direction == 2:
                y += 1
            elif direction == 3:
                x += 1
        elif command == 'L':
            direction -= 1
            if direction < 0:
                direction = 3
        elif command == 'R':
            direction += 1
            direction = direction % 4

        set_x.add(x)
        set_y.add(y)

    print((max(set_x) - min(set_x)) * (max(set_y) - min(set_y)))


