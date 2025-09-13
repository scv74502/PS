def solution(enroll, referral, seller, amount):
    tree = {}
    benefit = {}
    tree["minho"] = None
    benefit["minho"] = 0
    
    for name in enroll:
        tree[name] = ""
        benefit[name] = 0
    
    for i in range(len(enroll)):
        cur_member = enroll[i]
        inviter = referral[i]
        
        if inviter == "-":
            tree[cur_member] = "minho"
        else:            
            tree[cur_member] = inviter
        
    for i in range(len(seller)):
        cur_seller = seller[i]
        cur_benefit = amount[i] * 100
        
        inviters_benefit = cur_benefit // 10
        # print("1  :", cur_benefit, inviters_benefit)
        if inviters_benefit < 1:
            benefit[cur_seller] += cur_benefit
            continue
        benefit[cur_seller] += cur_benefit - inviters_benefit
        
        next_taker = tree[cur_seller]
        while next_taker is not None:           
            next_inviters_benefit = inviters_benefit // 10
            # print("fee : ", inviters_benefit, next_inviters_benefit)
            if next_inviters_benefit < 1:
                benefit[next_taker] += inviters_benefit
                break
            benefit[next_taker] += inviters_benefit - next_inviters_benefit
            inviters_benefit = next_inviters_benefit
            next_taker = tree[next_taker]
            
        
    return [benefit[name] for name in enroll]