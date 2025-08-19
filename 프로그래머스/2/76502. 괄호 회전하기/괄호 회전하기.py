def solution(s):
    def check_valid(tgt_str):
        stack = []
        for ch in tgt_str:
            if ch == '(' or ch == '{' or ch == '[':
                stack.append(ch)
            elif ch == ')':
                if not stack:
                    return False
                if stack and stack[-1] == '(':
                    stack.pop()
            elif ch == '}':
                if not stack:
                    return False
                if stack and stack[-1] == '{':
                    stack.pop()
            elif ch == ']':
                if not stack:
                    return False
                if stack and stack[-1] == '[':
                    stack.pop()
        return not stack
    
    str_len = len(s)
    str_list = list(s)
    answer = 0
    
    for i in range(str_len):
        if check_valid(str_list):
            answer += 1
        str_list.append(str_list.pop(0))
    
    return answer