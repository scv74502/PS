def solution(arr1, arr2):
    n, m, r = len(arr1), len(arr1[0]), len(arr2[0])
    answer = []

    for row in arr1:
        L = []
        for i in range(r):
            val = 0
            for j in range(m):
                val += row[j] * arr2[j][i]
                # print(i, j, val)
            L.append(val)
        answer.append(L)
                
            
            
    
    return answer