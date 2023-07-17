def solution(common):
    
    is_add = True
    
    if common[2] - common[1] == common[1] - common[0]:
        pass
    else:
        is_add = False
    
    if is_add:
        return common[-1] + (common[1] - common[0])
    else:
        return common[-1] * (common[1] / common[0])