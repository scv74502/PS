def solution(cacheSize, cities):
    cache = dict()
    answer = 0
    
    for req in cities:
        req = req.lower()
        
        for city in cache:
            cache[city] += 1
        
        if cacheSize == 0:
            return 5 * len(cities)
        
        if req not in cache:
            answer += 5
            
            
            if len(cache) >= cacheSize:
                sorted_cache = sorted(cache.items(), key = lambda x:(x[1], x[0]), reverse=True)
                # print(sorted_cache)
                sorted_cache.pop(0)
                cache = dict(sorted_cache)
                # print(cache)
                
            cache[req] = 0
                
        else:
            answer += 1
            cache[req] = 0
    return answer