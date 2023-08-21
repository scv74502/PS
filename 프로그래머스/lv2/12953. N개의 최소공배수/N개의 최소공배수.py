def gcd(a, b):
    if b > a:
        a, b = b, a
    
    while b != 0:
        n = a % b
        a = b
        b = n
    
    return a


def solution(arr):
    if len(arr) == 1:
        return arr[0]
    elif len(arr) == 2:
        return arr[0] * arr[1] // gcd(arr[0], arr[1])
    else:
        tmp = arr[0] * arr[1] // gcd(arr[0], arr[1])
        for i in range(2, len(arr)):
            tmp = tmp * arr[i] // gcd(tmp, arr[i])
            # print(tmp)
    
    return tmp
        