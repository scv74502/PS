def solution(picks, minerals):
    # 모든 광물을 캐거나, 곡괭이가 떨어지거나 경우로 나뉨
    all_tempt = min(sum(picks) * 5, len(minerals))
    dia_cnt, iron_cnt, stone_cnt = 0, 0, 0
    mineral_store = []
    answer = 0

    # 순서는 무조건 앞에서부터 캐야 하므로 0부터 all_tempt까지 전부 탐색하기
    for i in range(0, all_tempt):
        # 각 광물이 다이아몬드인지, 철인지, 돌인지 개수 저장하기
        if minerals[i] == "diamond":
            dia_cnt += 1
        elif minerals[i] == "iron":
            iron_cnt += 1
        if minerals[i] == "stone":
            stone_cnt += 1

        # 5개씩 끊거나, 맨 마지막일 때로 끊어서 저장하기
        if (i + 1) % 5 == 0 or i == all_tempt - 1:
            mineral_store.append((dia_cnt, iron_cnt, stone_cnt))
            # 저장 후 초기화
            dia_cnt, iron_cnt, stone_cnt = 0, 0, 0

    mineral_store.sort(key=lambda x: (x[0], x[1], x[2]), reverse=True)

    # 좋은 광물들을 먼저 빼놓았으므로, 좋은 곡괭이 먼저 사용해야 피로도가 최소화됨
    i = 0
    for dia_cnt, iron_cnt, stone_cnt in mineral_store:
        while picks[i] == 0:
            i += 1

        # 피로도 계산
        # 다이아 곡괭이
        if i == 0:
            answer += (dia_cnt + iron_cnt + stone_cnt)
        # 철 곡괭이
        elif i == 1:
            answer += (dia_cnt * 5 + iron_cnt + stone_cnt)
        # 돌 곡괭이
        elif i == 2:
            answer += (dia_cnt * 25 + iron_cnt * 5 + stone_cnt)

        picks[i] -= 1

    return answer