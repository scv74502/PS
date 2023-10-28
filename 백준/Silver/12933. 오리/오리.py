import sys

si = sys.stdin.readline
string = list(si().strip())

order = ['q', 'u', 'a', 'c', 'k']
visited = [False for _ in range(len(string))]
cnt = 0
k = 0

if string[0] != 'q' or len(string) % 5 != 0:
    print(-1)
    quit()
else:
    for i in range(len(string)):
        li = []
        for j in range(i, len(string)):
            if not visited[j] and string[j] == order[k]:
                k += 1
                li.append((string[j]))
                visited[j] = True
                if k == 5:
                    k = 0

        if len(li) != 0:
            if li[-1] != 'k':
                print(-1)
                quit()
            cnt += 1

    print(cnt)

