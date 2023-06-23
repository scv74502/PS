import sys

# # 자료구조 형식, 31256KB에 5476ms
# def calculate(calc_order, target_set:set, calc_number):
#     if calc_order == "add":
#         target_set.add(calc_number)
#     elif calc_order == "remove":
#         target_set.discard(calc_number)
#     elif calc_order == "check":
#         if calc_number in target_set:
#             print(1)
#         else:
#             print(0)
#     elif calc_order == "toggle":
#         if calc_number in target_set:
#             target_set.remove(calc_number)
#         else:
#             target_set.add(calc_number)
#     elif calc_order == "all":
#         target_set = set([i for i in range(1, 21)])
#     elif calc_order == "empty":
#         target_set = set()
#
#     return target_set
#
#
# start_set = set()
# repeat = int(sys.stdin.readline())
#
# for _ in range(repeat):
#     ipt = sys.stdin.readline().strip("\n").split(" ")
#     if len(ipt) == 1:
#         order, number = ipt[0], 0
#     else:
#         order, number = ipt[0], int(ipt[1])
#     start_set = calculate(order, start_set, number)
#     print(start_set)


# 비트마스킹
m = int(sys.stdin.readline())

bit = 0
for _ in range(m):
    command = sys.stdin.readline().split()

    if command[0] == "all":
        bit = (1 << 20) - 1
    elif command[0] == "empty":
        bit = 0
    else:
        op = command[0]
        num = int(command[1]) - 1

        # add
        if op == 'add':
            bit |= (1 << num)
        # remove
        elif op == 'remove':
            bit &= ~(1 << num)
        # check
        elif op == 'check':
            if bit & (1 << num) == 0:
                print(0)
            else:
                print(1)
        # toggle
        elif op == 'toggle':
            bit = bit ^ (1 << num)
