import sys


si = sys.stdin.readline
string = si().strip()
zero, one = string.split("1"), string.split("0")


def no_blank(nums: list):
    return [num for num in nums if num != '']


print(min(len(no_blank(zero)), len(no_blank(one))))