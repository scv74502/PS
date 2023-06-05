def solution(n):
    result = []
    
    while n:
        t = n % 3
        if not t:
            t = 3
            n -= 1
        result.append(str(t))
        n //= 3
    for i in range(len(result)):
        if result[i] == '3':
            result[i] = '4'
    
    return ''.join(result[::-1])
        
                
# def solution(n):
#     result = []

#     while n:
#         t = n % 3
#         if not t:
#             t = 3
#             n -= 1
#         result.append(str(t))
#         n //= 3
#     print(result[::-1])
#     for i in range(len(result)):
#         if result[i] == '3':
#             result[i] = '4'
#     return ''.join(result[::-1])