"""
1. 배열 내에서 최대값 위치와 최대값을 구한다
2. 최대값 위치 전까지 이익을 구한다
3. 최대값 다음부터 끝까지 배열에 1번을 수행하고, 반복한다
"""


sin = input
rpt = int(sin())

for repeat in range(1, rpt+1):
    N = int(sin())
    prices = list(map(int, sin().split()))

    max_val = max(prices)
    idx = prices.index(max_val)
    total_max, cur_profit = 0, 0

    while True:
        for i in range(0, idx):
            cur_profit += max_val - prices[i]
        # if cur_profit > total_max:
        total_max += cur_profit

        if idx < N-1:
            prices = prices[idx+1:]
            if prices:
                max_val = max(prices)
            else:
                break
            idx = prices.index(max_val)
            cur_profit = 0
        else:
            break

    print(f"#{repeat} {total_max}")

