def convert_time(str_time):
    return int(str_time[:2])*60 + int(str_time[3:])


def solution(book_time):
    times = dict()
    for book in book_time:
        start, end = convert_time(book[0]), convert_time(book[1])+10
        for t in range(start, end):
            if times.get(t) is None:
                times[t] = 1
            else:
                times[t] += 1

    return max(times.values())