import sys

sin = sys.stdin.readline
ipt_str = sin().strip()


def is_pel(string: str) -> int:
    size = len(string)
    for i in range(size, size // 2, -1):
        if string[i - 1] != string[size - i]:
            return 0
            break

    return 1


print(is_pel(ipt_str))
