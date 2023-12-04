# 한 사람만 앉는 테이블 없이 그룹을 지어야 한다
# M은 한 테이블에 앉을 수 있는 최대 인원, 테이블에 앉힐 총 인원
M = 10
N = 100


memo = {}
def check(remain, pre):
    # 이전에 계산한 적 있으면, 메모했던 값을 반환
    key = str([remain, pre])
    if key in memo:
        return memo[key]
    # 배치할 사람이 없다면 종료
    if remain < 0:
        return 0
    elif remain == 0:
        return 1

    # 재귀적 처리
    cnt = 0
    for i in range(pre, M + 1):
        cnt += check(remain - i, i)
    # 계산 결과 반환하며 메모하기
    memo[key] = cnt
    return cnt


print(check(N, 2))