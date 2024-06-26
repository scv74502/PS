import heapq


def convert_time(str_time):
    return int(str_time[:2])*60 + int(str_time[3:])


def solution(book_time):
    rooms = []
    book_time.sort(key = lambda _:_[0])
    for book in book_time :
        check_in = convert_time(book[0])
        check_out = convert_time(book[1]) + 10
        if rooms and rooms[0] <= check_in :
            heapq.heappop(rooms)
        heapq.heappush(rooms,check_out)
    return len(rooms)