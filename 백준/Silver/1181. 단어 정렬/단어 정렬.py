import sys

n = int(sys.stdin.readline())
words = list(set([sys.stdin.readline().strip() for _ in range(n)]))
words.sort(key = lambda x:(len(x), x))

for word in words:
    print(word)