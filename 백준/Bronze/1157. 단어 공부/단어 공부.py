import sys

# print(ord('A')) 65
# print(ord('Z')) 90
# print(ord('a')) 97
# print(ord('z')) 122

plain = sys.stdin.readline().strip()

plain = plain.upper()
count_dict = dict()

for i in range(65, 91):
    count_dict[chr(i)] = 0

for char in plain:
    count_dict[char] += 1

counted = sorted(list(count_dict.items()), key=lambda x: x[1], reverse=True)
if len(counted) == 1:
    print(counted[0][0])
else:
    if counted[0][1] == counted[1][1]:
        print("?")
    else:
        print(counted[0][0])
