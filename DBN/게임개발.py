"""
입력 예시
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1

첫째 줄에는 맵의 세로와 가로 크기인 N과 M
둘째 줄에는 현재 캐릭터가 있는 칸의 좌표와 바라보는 방향 d(0, 1, 2, 3)가 주어짐
d는 각각 북쪽 동쪽 남쪽 서쪽
셋째 줄부터 N+2번째 줄까지 지도 데이터
"""
import sys

sin = sys.stdin.readline
N, M = map(int, sin().split())
cn, cm, cdir = map(int, sin().split())
gmap = [list(map(int, sin().split())) for _ in range(N)]
record = [[0] * M for _ in range(N)]
record[cn][cm] = 1

# 북, 동, 남, 서
move_n = [-1, 0, 1, 0]
move_m = [0, -1, 0, 1]

# 이동 거리와 회전 횟수 카운트
count, turn_time = 1, 0


# 좌회전하는 함수
def turn_left():
    global cdir
    cdir += 1
    if cdir > 3:
        cdir = 0


while True:
    turn_left()
    turn_time += 1

    # 왼쪽으로 바라본 방향에서 한칸 앞으로 이동했을 때 칸을 탐색
    nn, nm = cn + move_n[cdir], cm + move_m[cdir]

    # 다음 좌표가 범위에 맞고, 뒤로 이동할 칸이 바다 아니면서 방문한 적 없으면
    if 0 <= nn < N and 0 <= nm < M and gmap[nn][nm] == 0 and record[nn][nm] == 0:
        count += 1
        cm, cn = nm, nn
        record[nn][nm] = 1
        turn_time = 0

    # 4방향 모두 주위에 칸이 없으면
    if turn_time >= 4:
        # 현재 보고있는 방향에서 뒤로 한 칸 이동
        nn, nm = cn - move_n[cdir], cm - move_m[cdir]
        # 다음 좌표가 범위에 맞고 뒤로 이동할 칸이 바다면
        if 0 <= nn < N and 0 <= nm < M and gmap[nn][nm] == 1:
            break
        else:
            cn, cm = nn, nm
        turn_time = 0


print(count)
