def solution(sequence, k):
    left = 0
    summary = 0
    answer = []

    for right in range(0, len(sequence)):
        summary += sequence[right]
        if summary == k:
            answer.append([left, right])

        while summary > k:
            summary -= sequence[left]
            left += 1
            if summary == k:
                answer.append([left, right])

    answer.sort(key=lambda x: ((x[1] - x[0]), x[0]))
    return answer[0]