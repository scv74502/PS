import sys


si = sys.stdin.readline
N, M = map(int, si().split(" "))
nums = list(map(int, si().split(" ")))
nums.sort()
res = []



def bt(num: int):
    if len(res) == M:
        print(" ".join(map(str, res)))
        return
    # backtracking 중 이전에 사용된 숫자를 저장함
    # nums가 sorted 되어 있으므로 중복으로 숫자 추가하는 경우 피할 수 있다
    before_used = 0
    for i in range(num, N):
        if before_used != nums[i]:
            res.append(nums[i])
            before_used = nums[i]
            bt(i)
            res.pop()


bt(0)


