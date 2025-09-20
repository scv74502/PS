def solution(phone_book):
    number_map = set()
    phone_book.sort(key = lambda x:len(x))
    for phone_number in phone_book:
        for i in range(1, len(phone_number)):
            sliced_number = phone_number[:i]
            number_map.add(sliced_number)
    # print(number_map)
    for phone_number in phone_book:
        if phone_number in number_map:
            return False
    return True
            