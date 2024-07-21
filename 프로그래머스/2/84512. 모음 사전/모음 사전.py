import sys
from bisect import *


def solution(word):
    sys.setrecursionlimit(100000000)
    vowels = 'AEIOU'
    sb = []
    words = []
    def bt():
        if len(sb) == 5:
            words.append(''.join(sb))
            return
        elif sb:
            words.append(''.join(sb))

        for i in range(5):
            sb.append(vowels[i])
            bt()
            sb.pop()
    bt()
    return bisect(words, word)