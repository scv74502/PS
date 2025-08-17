def solution(numbers, direction):
    
    if direction == "left":
        num = numbers[0]
        
        for i in range(0, len(numbers)-1):
            numbers[i] = numbers[i+1]
        numbers[-1] = num
    else:
        num = numbers[-1]
        
        for i in range(len(numbers)-1, 0, -1):
            numbers[i] = numbers[i-1]
        numbers[0] = num
    
    return numbers