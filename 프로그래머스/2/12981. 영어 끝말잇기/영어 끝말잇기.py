def solution(n, words):
    answer = [0, 0]
    prev_char = None
    word_set = set()

    for i, word in enumerate(words):       
        # print(word_set)
        cur_turn = ((i) // n) + 1
        cur_person_number = (i) % n + 1
        # print(cur_turn, cur_person_number)
        
        if (prev_char and word[0] != prev_char[-1]) or word in word_set:
            # print(cur_turn, cur_person_number, word, i)
            answer = [cur_person_number, cur_turn]
            return answer
        
        
        word_set.add(word)        
        prev_char = word[-1]

    return answer