import sys

sin = sys.stdin.readline
N, M = map(int, sin().split())
board = [list(sin().strip()) for _ in range(N)]
res = sys.maxsize

for i in range(N - 7):
    for j in range(M - 7):
        draw_w, draw_b = 0, 0

        for a in range(i, i + 8):
            for b in range(j, j + 8):
                # 같은 체크 영역을 판의 가로좌표 + 세로좌표를 2로 나눈 나머지로 판별 가능하다
                if (a + b) % 2 == 0:  # 나머지가 0인 체크 영역
                    if board[a][b] != 'B':
                        draw_b += 1
                    if board[a][b] != 'W':
                        draw_w += 1
                else:  # 나머지가 1인 체크 영역은 0인 체크 영역이랑 무조건 색이 반대이다!
                    if board[a][b] != 'W':
                        draw_b += 1
                    if board[a][b] != 'B':
                        draw_w += 1

        res = min(res, min(draw_b, draw_w))

print(res)
