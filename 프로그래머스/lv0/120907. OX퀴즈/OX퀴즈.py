"""
eval 함수 : 문자열로 식이나 python 코드 입력한 것의 실행결과 반환
"""


def solution(quiz):
    splited = [question.split(" = ") for question in quiz]
    # print(splited)
    answer = []
    
    for question in splited:
        if eval(question[0]) == int(question[1]):
            answer.append("O")
        else:
            answer.append("X")
    return answer