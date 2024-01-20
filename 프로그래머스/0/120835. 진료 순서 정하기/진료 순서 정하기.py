def solution(emergency):
    sorted_emergency = sorted(emergency, reverse=True)
    print(sorted_emergency)
    
    answer = [sorted_emergency.index(eme)+1 for eme in emergency]
        
    return answer