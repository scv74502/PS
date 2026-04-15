def solution(message, spoiler_ranges):
    words = message.split(" ")    
    start_idx = 0
    word_info = [["", 0, 0] for _ in range(len(words))]
    spoiled_range = [False for _ in range(len(message))]
    
    for i in range(len(words)):
        word = words[i]
        end_idx = start_idx + len(word) - 1
        word_info[i][0] = word
        word_info[i][1] = start_idx
        word_info[i][2] = end_idx
        start_idx = end_idx + 2
        
    for spoil_start, spoil_end in spoiler_ranges:
        spoiled_range[spoil_start:spoil_end + 1] = [True] * (spoil_end - spoil_start + 1)                
            
    spoiler_words = set()    
    no_spoiler_words = set()
    # 한 번만 등장산 스포 방지 단어가 중요 단어
    important_words = set()
    
    for word, start, end in word_info:
        is_spoiler = False
        for i in range(start, end + 1):
            if spoiled_range[i]:
                is_spoiler = True
                break
        if is_spoiler and not word in spoiler_words:
            spoiler_words.add(word)        
        elif not is_spoiler:
            no_spoiler_words.add(word)        
    
    important_words = spoiler_words - no_spoiler_words
    # print(spoiler_words)
    # print(no_spoiler_words)
    # print(important_words)
    
    answer = len(important_words)
    return answer