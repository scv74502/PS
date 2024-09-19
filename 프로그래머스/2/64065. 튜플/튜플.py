def solution(s):
    parsed = s.replace("{", "").replace("}", "").split(",")
    number_count = dict()
    
    for s in parsed:
        num = int(s)
        if num in number_count:
            number_count[num] += 1
        else:
            number_count[num] = 1
        
    result = sorted(number_count, key=lambda x:number_count[x], reverse=True)
    # print(result)
    
    return result