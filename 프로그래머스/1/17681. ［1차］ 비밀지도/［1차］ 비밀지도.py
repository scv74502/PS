def solution(n, arr1, arr2):
    map1, map2 = [[False for _ in range(n)] for __ in range(n)], [[False for _ in range(n)] for __ in range(n)]
    
    
    def process(narr: list, map_arr: list) -> None:
        for h, num in enumerate(narr):
            cur, idx = num, n-1
            while idx >= 0:
                # print(h, idx, cur)
                if cur % 2 == 1:
                    map_arr[h][idx] = True
                else:
                    map_arr[h][idx] = False
                idx -= 1
                cur = cur // 2
            
    process(arr1, map1)
    process(arr2, map2)
    # print(map1)
    # print("\n")
    # print(map2)
    answer = []
    
    for i in range(n):
        res = ""
        for j in range(n):
            if map1[i][j] == map2[i][j] == False:
                res += " "
            elif map1[i][j] or map2[i][j]:
                res += "#"
        answer.append(res)
    # print(answer)
    return answer