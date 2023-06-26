def solution(name, yearning, photo):
    score_dict = dict()
    for key, value in zip(name, yearning):
        score_dict[key] = value
    
    answer = [sum([score_dict[people] if people in score_dict else 0 for people in image]) for image in photo]
    return answer