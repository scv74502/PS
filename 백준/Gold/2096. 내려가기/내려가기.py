import sys

"""
슬라이딩 윈도우 기법을 사용, dp 배열 전부를 만들면 메모리 초과가 발생한다!
이 경우에는 한 줄씩 매변 새로운 배열로 갱신시켜야 함
그리고 한 줄에는 숫자가 무조건 3개이고 N행 3열의 배열이 입력으로 주어짐
"""

input = sys.stdin.readline
N = int(input())

arr = list(map(int, input().split()))
dp_max = arr
dp_min = arr

# 입력 첫 줄을 처리하였으므로, N-1번 반복문 돌리면 N줄 모두 처리 가능함
for _ in range(N-1):
    arr = list(map(int, input().split()))
    dp_max = [arr[0] + max(dp_max[0], dp_max[1]), arr[1] + max(dp_max[0], dp_max[1], dp_max[2]), arr[2] + max(dp_max[1], dp_max[2])]
    dp_min = [arr[0] + min(dp_min[0], dp_min[1]), arr[1] + min(dp_min[0], dp_min[1], dp_min[2]), arr[2] + min(dp_min[1], dp_min[2])]

print(max(dp_max), min(dp_min))




