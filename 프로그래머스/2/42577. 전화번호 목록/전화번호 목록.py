def solution(phone_book):
    hasp_map = {}
    for pNumber in phone_book:
        hasp_map[pNumber] = 1

    for phone_num in phone_book:
        temp = ''
        for num in phone_num:
            temp += num
            if temp in hasp_map and temp != phone_num:
                return False
    return True