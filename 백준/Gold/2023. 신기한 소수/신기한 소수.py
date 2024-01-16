"""
맨 앞자리가 소수인 2, 3, 5, 7만 가능하다는 사실을 파악했어야 함
맨 앞자리 제외한 나머지 자리는 홀수(자릿수 상관없이 한 자리의 2 제외한 짝수면 2로 나누어지므로)만 가능하다(1, 3, 5, 7, 9)
그렇다면 역으로 2부터 n 자릿수까지 숫자를 붙여 나가는 방식도 가능하다!
"""
import sys


sys.setrecursionlimit(10000)
sin = sys.stdin.readline
N = int(sin())


def is_prime(num: int) -> bool:
    if num == 2:
        return True
    elif num % 2 == 0:
        return False

    for i in range(3, int(num / 2) + 1, 2):
        if num % i == 0:
            return False

    return True


def bt(num):
    if 10 ** (N-1) <= num < 10 ** N:
        print(num)
        return

    for i in range(1, 10, 2):
        if is_prime(num * 10 + i):
            # print("True")
            bt(num * 10 + i)

# print(10 ** (N-1), 10 ** N)
bt(2)
bt(3)
bt(5)
bt(7)


