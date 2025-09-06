def solution(want, number, discount):
    N = len(discount)
    answer = 0
    total_amount = 0
    buy_list = {}
    
    for good, amount in zip(want, number):        
        buy_list[good] = amount
        total_amount += amount
    
    if total_amount > len(discount):
        return 0
        
    for i in range(total_amount):        
        if discount[i] in buy_list:
            buy_list[discount[i]] -= 1
    
    if is_all_bought(buy_list):
        answer += 1
    
    for i in range(1, N - total_amount + 1):
        past_good = discount[i-1]
        if past_good in buy_list:
            buy_list[past_good] += 1
            
        cur_good = discount[total_amount + i - 1]        
        if cur_good in buy_list:
            buy_list[cur_good] -= 1
            
        # print(past_good, cur_good, buy_list)
        if is_all_bought(buy_list):
            answer += 1        
    
    return answer


def is_all_bought(buy_list: dict()):
    for key in buy_list.keys():
        if buy_list[key] > 0:
            return False
    
    return True