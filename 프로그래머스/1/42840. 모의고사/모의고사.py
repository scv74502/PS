def solution(answers):
    res = []
    N = len(answers)
    s1 = [1, 2, 3, 4, 5]
    s2 = [2, 1, 2, 3, 2, 4, 2, 5]
    s3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    checks = [0, 0, 0]

    for i, answer in enumerate(answers):
        if s1[i % len(s1)] == answer:
            checks[0] += 1
        
        if s2[i % len(s2)] == answer:
            checks[1] += 1
            
        if s3[i % len(s3)] == answer:
            checks[2] += 1

    mval = max(checks)
    for i, check in enumerate(checks):
        if check == mval:
            res.append(i+1)
    
    return res