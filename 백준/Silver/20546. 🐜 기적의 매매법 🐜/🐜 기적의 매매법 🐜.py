import sys


si = sys.stdin.readline
cash = int(si().strip())
prices = list(map(int, si().strip().split(" ")))


def bnp(cash: int, prices: list):
    stock = 0
    for price in prices:
        if cash >= price:
            stock += cash // price
            cash -= (cash // price * price)
        # else:
            # break

    return stock * prices[-1] + cash


def timing(cash: int, prices: list):
    increasing, decreasing = 0, 0
    stock = 0

    for i in range(1, len(prices)):
        if prices[i] > prices[i-1]:
            increasing += 1
            decreasing = 0

            if increasing >= 3 and stock > 0:
                cash += prices[i] * stock
                stock = 0


        elif prices[i] < prices[i-1]:
            decreasing += 1
            increasing = 0

            if decreasing >= 3 and cash >= prices[i]:
                stock += cash // prices[i]
                cash -= (cash // prices[i] * prices[i])


        else:
            increasing, decreasing = 0, 0

    return stock * prices[-1] + cash


bnp_res, tim_res = bnp(cash, prices), timing(cash, prices)
# print(bnp_res, tim_res)

if bnp_res > tim_res:
    print("BNP")
elif bnp_res < tim_res:
    print("TIMING")
else:
    print("SAMESAME")

