import sys

# print(ord('A')) 65
# print(ord('Z')) 90
# print(ord('a')) 97
# print(ord('z')) 122


def calculate(calc_order, target_set:set, calc_number):
    if calc_order == "add":
        target_set.add(calc_number)
    elif calc_order == "remove":
        target_set.discard(calc_number)
    elif calc_order == "check":
        if calc_number in target_set:
            print(1)
        else:
            print(0)
    elif calc_order == "toggle":
        if calc_number in target_set:
            target_set.remove(calc_number)
        else:
            target_set.add(calc_number)
    elif calc_order == "all":
        target_set = set([i for i in range(1, 21)])
    elif calc_order == "empty":
        target_set = set()

    return target_set


start_set = set()
repeat = int(sys.stdin.readline())

for _ in range(repeat):
    ipt = sys.stdin.readline().strip("\n").split(" ")
    if len(ipt) == 1:
        order, number = ipt[0], 0
    else:
        order, number = ipt[0], int(ipt[1])
    start_set = calculate(order, start_set, number)
    # print(start_set)


