def solution(n, left, right):
    # 1 2 3 4
    # 2 2 3 4
    # 3 3 3 4
    # 4 4 4 4
    
    def calc_number_on_square(n, number):
        row = number // n + 1
        col = number % n + 1
        
        if col <= row:
            return row
        else:
            return col
                
    
    answer = [calc_number_on_square(n, num) for num in range(left, right+1)]
    return answer