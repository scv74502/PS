def solution(n):
    idx = 1
    answer = 1
    while True:
        if answer * idx < n:
            idx += 1
            answer = idx * answer
        else:
            return idx