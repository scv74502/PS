def solution(n):
    tri = ''
    while(n > 0):
        n, res = divmod(n, 3)
        tri += str(res)
    return int(tri, 3)