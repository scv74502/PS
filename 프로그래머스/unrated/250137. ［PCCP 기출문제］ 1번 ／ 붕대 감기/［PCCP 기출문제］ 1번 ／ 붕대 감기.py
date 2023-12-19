def solution(bandage, health, attacks):
    answer = 0
    current, maintained = 0, 0
    sk_time, heal_per_sec, heal_bonus = bandage
    cur_hp = health
    
    
    for attack in attacks:
        att_sec, damage = attack
        # 몬스터 공격 직전까지 체력 회복함
        maintained = att_sec - current - 1
        current = att_sec
        
        cur_hp += maintained * heal_per_sec + heal_bonus * (maintained // sk_time)
        
        if cur_hp > health:
            cur_hp = health
        
        cur_hp -= damage
        
        if cur_hp <= 0:
            return -1
    
    return cur_hp