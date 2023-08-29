def solution(citations):
    cits = citations
    
    for cit in range(len(cits), -1, -1):
        refered = 0
        for compare in cits:
            if compare >= cit:
                refered += 1
        if refered >= cit:
            return cit