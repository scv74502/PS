def solution(people, limit):
    people.sort(reverse=True)
    l, r = 0, len(people)-1    
    answer = 0
    margin = limit
    
    while l <= r:
        margin -= people[l]
        l += 1
        
        if margin >= people[r]:
            margin -= people[r]
            r -= 1
        
        answer += 1
        margin = limit
    
    return answer