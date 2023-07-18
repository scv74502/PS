"""
dots의 길이가 정해져 있기 때문에 unpack 후에 풀기
"""


def solution(dots):
    [[x1, y1], [x2, y2], [x3, y3], [x4, y4]] = dots
    if (y2 - y1) / (x2 - x1) == (y4 - y3) / (x4 - x3):
        return 1
    if (y3 - y1) / (x3 - x1) == (y4 - y2) / (x4 - x2):
        return 1
    if (y4 - y1) / (x4 - x1) == (y3 - y2) / (x3 - x2):
        return 1
    else:
        return 0
    
    