def solution(record):
    answer = []
    uid_nickname_map = {}
    
    for rec in record:
        cur_input = list(rec.split(" "))
        if len(cur_input) > 2:
            command, uid, nickname = cur_input
        else:
            command, uid  = cur_input
        
        if command == "Enter":
            uid_nickname_map[uid] = nickname
            answer.append([uid, "Enter"])
        elif command == "Leave":            
            answer.append([uid, "Leave"])
        elif command == "Change":
            uid_nickname_map[uid] = nickname
    
    for i in range(len(answer)):
        uid, command = answer[i]
        if command == "Enter":
            answer[i] = get_enter_message(uid_nickname_map[uid])
        elif command == "Leave":
            answer[i] = get_leave_message(uid_nickname_map[uid])
    
    return answer


def get_enter_message(nickname: str):
    return f"{nickname}님이 들어왔습니다."


def get_leave_message(nickname: str):
    return f"{nickname}님이 나갔습니다."

