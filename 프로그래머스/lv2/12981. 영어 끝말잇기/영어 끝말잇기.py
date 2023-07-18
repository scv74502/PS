def solution(n, words):
    answer = []
    appeared = [words[0]]

    for i in range(1, len(words)):
        # print(words[i])
        # print(appeared)
        # 탈락 조건은 나왔던 단어 말하거나, 끝말잇기 조건 위배한 경우
        if words[i] in appeared or words[i][0] != words[i-1][-1]:            
            answer = [(i % n) + 1, (i // n) +1]
            return answer
        
        # 나왔던 단어 목록에 추가하기
        appeared.append(words[i])
        

    return [0, 0]