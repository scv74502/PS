def solution(elements):
    answer = 0
    dp = [0 for _ in range(1000)]
    appeared = set()
    for i in range(1, len(elements)+1):
        for j in range(0, len(elements)):
            start = j
            end = start + i
            if end > len(elements):
                # print("end = ", end)
                # print(elements[start:], elements[:end-len(elements)])
                res = elements[start:] + elements[:end-len(elements)]
            else:
                # print(elements[start:end])
                res = elements[start:end]
            
            # print(res)
            appeared.add(sum(res))
                            
    # print(appeared)
    # for i in range(1, len(elements)+1):
    #     print(dp[i])
        # print(i)
    # test = [1, 2, 3, 4]
    # print(test[2:] + test[:2])
    
    return len(appeared)