from collections import deque


def solution(n, wires):
    res = 100
    graph = [[] for _ in range(n)]

    for i, j in wires:
        graph[i - 1].append(j - 1)
        graph[j - 1].append(i - 1)

    def bfs(start: int):
        visited = [False for _ in range(n)]
        dq = deque()
        dq.append(start)
        cnt = 0

        while dq:
            cnt += 1
            cur = dq.popleft()
            visited[cur] = True
            for node in graph[cur]:
                if not visited[node]:
                    dq.append(node)

        return cnt

    for i, j in wires:
        graph[i - 1].remove(j - 1)
        graph[j - 1].remove(i - 1)

        res = min(res, abs(bfs(i - 1) - bfs(j - 1)))

        graph[i - 1].append(j - 1)
        graph[j - 1].append(i - 1)

    return res