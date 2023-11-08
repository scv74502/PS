def isPalindrome(str: str):
    if str == str[::-1]:
        return True
    return False

def solution(s):
    answer = 1

    for start in range(len(s)):
        for end in range(len(s), start-1, -1):
            check = s[start: end]
            if len(check) > answer and isPalindrome(check):
                answer = max(answer, end - start)
    
    return answer