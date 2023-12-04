# 한 사람만 앉는 테이블 없이 그룹을 지어야 한다
# M은 한 테이블에 앉을 수 있는 최대 인원, 테이블에 앉힐 총 인원
M = 10
N = 100


def check(remain, pre):
    # 배치할 사람이 없으면 종료
    if remain < 0:
        return 0
    elif remain == 0:
        return 1

    # 재귀적으로 처리하기
    cnt = 0
    for i in range(pre, M + 1): # 이전에 배치한 사람부터 남은 사람들까지
        cnt += check(remain - i, i)
    return cnt


print(check(N, 2))