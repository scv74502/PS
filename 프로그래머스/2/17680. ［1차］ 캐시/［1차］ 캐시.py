from collections import deque


def solution(cacheSize, cities):
    answer = 0
    
    cache = dict()
    
    for city in cities:
        city = city.lower()
        if cacheSize == 0:
            answer += 5
        elif len(cache) < cacheSize and city not in cache:
            cache[city] = 0
            answer += 5
        elif city in cache:
            answer += 1
            cache[city] = 0
        else:
            temp = cache.items()
            temp = sorted(temp, key = lambda x:x[1])
            if temp:
                temp.pop()
            cache = dict(temp)
            cache[city] = 0
            answer += 5
        for key in cache.keys():
            cache[key] += 1
        
        
    return answer