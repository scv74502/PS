def solution(id_list, report, k):
    N = len(id_list)
    id_idx = dict()
    reported_cnt = dict()
    suspended_users = set()
    answer = [0 for _ in range(N)]
    
    report_record = dict()
    for i, id in enumerate(id_list):
        report_record[id] = set()
        reported_cnt[id] = 0
        id_idx[id] = i
        
    for record in report:
        reporter, reported = record.split(" ")
        
        if reported in report_record[reporter]:
            continue
            
        report_record[reporter].add(reported)
        reported_cnt[reported] += 1
        
        if reported_cnt[reported] >= k:
            reporter_idx = id_idx[reporter]
            suspended_users.add(reported)
        
        # print(reported_cnt)
        # print(answer)
        
    for user in suspended_users:
        user_idx = id_idx[user]
        for key in report_record.keys():
            if user in report_record[key]:
                reporter_idx = id_idx[key]
                answer[reporter_idx] += 1
            
    
    return answer