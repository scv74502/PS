def solution(numbers):
    answer = [-1 for _ in range(len(numbers))]
    stack = []
    
    for idx, number in enumerate(numbers):
        while stack and numbers[stack[-1]] < number:
            answer[stack.pop()] = number
        stack.append(idx)
    return answer