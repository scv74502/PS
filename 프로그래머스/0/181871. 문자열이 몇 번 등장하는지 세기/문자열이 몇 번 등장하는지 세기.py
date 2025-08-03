def solution(myString, pat):
    word_len = len(pat)
    answer = 0
    
    cur_word = myString[0:word_len]
    
    
    for i in range(0, len(myString) - word_len):
        if(cur_word == pat):
            answer += 1
        cur_word = cur_word[1:] + myString[i + word_len]
    
    if(cur_word == pat):
        answer += 1
            
    return answer