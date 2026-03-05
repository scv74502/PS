def solution(n):
    answer = 0
    # 체크 배열: 해당 영역에 이미 퀸이 있는지 여부
    check_col = [False] * n
    check_diag1 = [False] * (2 * n) # / 방향 (row + col)
    check_diag2 = [False] * (2 * n) # \ 방향 (row - col + n)

    def bt(row):
        nonlocal answer
        if row == n:
            answer += 1
            return

        for col in range(n):
            if not check_col[col] and not check_diag1[row + col] and not check_diag2[row - col + n]:
                check_col[col] = check_diag1[row + col] = check_diag2[row - col + n] = True
                bt(row + 1)
                check_col[col] = check_diag1[row + col] = check_diag2[row - col + n] = False

    bt(0)
    return answer