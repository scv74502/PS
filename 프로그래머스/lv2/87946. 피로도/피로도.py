def solution(k, dungeons):
    answer = [-1]
    visited = [False] * len(dungeons)
    dl = []
    
    def bt(tired, dungeons, cnt, max_cnt):
        res = max_cnt
        for i in range(len(dungeons)):
            if visited[i] == False and tired >= dungeons[i][0]:
                visited[i] = True
                res = bt(tired-dungeons[i][1], dungeons, cnt+1, res)
                visited[i] = False
        
        # print(max(cnt, res))
        return max(cnt, res)
                
        
        
                
    res = bt(k, dungeons, 0, 0)
    return res