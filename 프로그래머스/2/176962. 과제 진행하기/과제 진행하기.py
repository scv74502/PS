from collections import *
import heapq


def solution(plans):
    answer = []
    buffer = []
    for plan in plans:
        time, minute = map(int, plan[1].split(":"))
        plan[1] = time * 60 + minute
        plan[2] = int(plan[2])
    plans.sort(key=lambda x: x[1])
    print(plans)
    plans = deque(plans)

    while plans:
        cs, ct, cd = plans.popleft()
        # 플랜에서 마지막 과목이라면 그냥 끝냄
        if not plans:
            answer.append(cs)
            # 끝내고 버퍼에 남은 과목들 순서대로 끝냄
            while buffer:
                ls, ld = buffer.pop()
                answer.append(ls)
        # 다음 과목도 있으면 다음 과목 시작시간과 현과목 남은시각 비교
        else:
            left = plans[0][1] - ct
            buffer.append([cs, cd])
            while buffer and left > 0:
                buffer[-1][1] -= left
                if buffer[-1][1] <= 0:
                    answer.append(buffer[-1][0])
                    left = buffer[-1][1] * -1
                    buffer.pop()
                else:
                    left = 0
                    break

    return answer