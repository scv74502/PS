import sys

sin = sys.stdin.readline
ipt_str = sin().strip()


def is_pel(string: str) -> int:
    if string == string[::-1]:
        return 1
    else:
        return 0


print(is_pel(ipt_str))
