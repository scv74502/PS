import sys

# print(ord('A')) 65
# print(ord('Z')) 90
# print(ord('a')) 97
# print(ord('z')) 122

plain = sys.stdin.readline().strip("\n")


def rot13(char):
    if 65 <= ord(char) <= 90:
        if ord(char) + 13 > 90:
            return chr(ord(char) + 13 - 90 + 65-1)
        else:
            return chr(ord(char) + 13)
    elif 97 <= ord(char) <= 122:
        if ord(char) + 13 > 122:
            return chr(ord(char) + 13 - 122 + 97-1)
        else:
            return chr(ord(char) + 13)
    else:
        return char


print(''.join([rot13(char) for char in plain]))
