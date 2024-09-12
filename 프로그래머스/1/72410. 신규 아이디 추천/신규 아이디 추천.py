import sys
import re

def solution(new_id):
    step1 = new_id.lower()
    step2 = ''
    
    
    for ch in step1:
        if ch.isalpha() or ch.isnumeric() or ch == "-" or ch == "_" or ch == ".":
            step2 += ch
        
    #print(step2)
    step3 = ''
    for i in range(len(step2)):
        if step2[i] != '.':
            step3 += step2[i]
        else:
            if step3 and step3[-1] == '.':
                continue
            step3 += step2[i]
        
    step4 = ''
    for i in range(len(step3)):
        if (i == 0 or i + 1 == len(step3)) and step3[i] == '.':
            continue
        step4 += step3[i]
    
    #print(step4)
    
    if not step4:
        step5 = "a"
    else:
        step5 = step4
    
    if len(step5) >= 16:
        if step5[14] == ".":
            step6 = step5[:14]
            #print(len(step6))
        else:
            step6 = step5[:15]
            #print(len(step6))
    else:
        step6 = step5    
    # print(f"step6 : {step6}, len : {len(step6)}")
        
    step7 = step6
    if len(step7) <= 2:
        while len(step7) < 3:
            step7 += step7[-1]
    
    return step7
    
    
    