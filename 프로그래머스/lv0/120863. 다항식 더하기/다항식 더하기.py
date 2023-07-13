def solution(polynomial):
    nums = polynomial.split(" + ")
    integer = 0
    coef = 0
    for num in nums:
        if 'x' in num and len(num) > 1:
            coef += int(num[:-1])
        elif 'x' in num and len(num) == 1:
            coef += 1
        else:
            integer += int(num)
        
    
    answer = ''
    if coef > 1 and integer > 0:
        answer += str(coef) + 'x' + ' + ' + str(integer)
    elif coef == 1 and integer > 0:
        answer += 'x' + ' + ' + str(integer)
    elif coef > 1 and integer == 0:
        answer += str(coef)+'x'
    elif coef == 1 and integer == 0:
        answer = 'x'
    elif coef == 0 and integer != 0:
        answer += str(integer)
    
    return answer