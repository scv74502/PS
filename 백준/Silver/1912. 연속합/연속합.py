import sys
"""
dp 배열 내부에서 최대값 찾는 방식으로 해결하려다 실패함
dp 배열 내부의 최대값을 리턴하지 말고, 기억하는 내용을 리셋하고 지금까지 최대값 더하는 식으로 접근 변경함
"""


sin = sys.stdin.readline
N = int(sin())
numbers = list(map(int, sin().split(" ")))
dp = [-1001 for _ in range(N)]
max_value = numbers[0]
dp[0] = numbers[0]

for i in range(1, N):
    dp[i] = max(dp[i-1] + numbers[i], numbers[i])
    max_value = max(dp[i], max_value)

# print(dp)
print(max_value)

