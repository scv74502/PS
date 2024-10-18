import sys
from bisect import *

sys.setrecursionlimit(100000000)


def solution(word):        
    vowels = "AEIOU"
    sb = []
    words = []
    
    def bt():    
        # 글자가 5글자면 탐색 종료
        if(len(sb) == 5):            
            words.append(''.join(sb))
            return
        elif sb:
            words.append(''.join(sb))
        
        for letter in vowels:
            sb.append(letter)
            bt()
            sb.pop()
    
    bt()
    #print(words)
    return bisect(words, word)
        