from collections import Counter

def solution(participant, completion):
    #answer = Counter(participant) - Counter(completion)
    #return list(answer.keys())[0]
    
    participant.sort()
    completion.sort()

    for p, c in zip(participant, completion):
        if p != c:
            return p
    print(participant[-1])
    return participant[-1]