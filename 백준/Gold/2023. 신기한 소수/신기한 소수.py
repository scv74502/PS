"""
1. 수는 한 자리부터 8자리까지
2. 맨 왼쪽 첫 자리는 소수인 2, 3, 5, 7만 가능
3. 그 이후 자리들은 홀수여야 한다(1, 3, 5, 7, 9)
4. N개의 9로 이루어진 수부터 내려가는 식으로 검사 -> 일일히 체크해야 함, 에라토스테네스 체도 메모리 제한 탓에 사용 불가함
-> 그러나 첫 자리부터 오른쪽으로 수를 추가하다가 프린트하는 방식이면 정렬도 수행하고 따로 저장 안해도 된다
# 두 번째 자리 수부터 붙여나갈 때, 1도 고려해야 한다(31같은 케이스 있다)
# 소수 판별 함수 부분에서 3 이상의 홀수를 체크하는 이유는 is_prime은 두 자리수부터 동작하기 때문이다(한 자리수 소수는 체크할 일이 없어진다)
"""
import math
import sys


sin = sys.stdin.readline


def is_prime(num: int) -> bool:
    if num == 2:
        return True
    elif num % 2 == 0:
        return False

    for i in range(3, int(math.sqrt(num)) + 1, 2):
        if num % i == 0:
            return False

    return True


def bt(num: int):
    if 10 ** (N-1) <= num < 10 ** N:
        print(num)
        return

    num *= 10
    for i in range(1, 10, 2):
        if is_prime(num + i):
            bt(num + i)


if __name__ == '__main__':
    sys.setrecursionlimit(10000)
    N = int(sin())
    bt(2)
    bt(3)
    bt(5)
    bt(7)
