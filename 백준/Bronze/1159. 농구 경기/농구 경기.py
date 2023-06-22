import sys

times = int(sys.stdin.readline())
freq_dict = dict()

for i in range(ord('a'), ord('z')+1):
    freq_dict[chr(i)] = 0

for _ in range(times):
    freq_dict[sys.stdin.readline().strip()[0]] += 1

# for freq in freq_dict.values():
#     print(freq)

res = list(filter(lambda x:x[1] >= 5, freq_dict.items()))
answer = ''

for result in res:
    answer += result[0]
if len(answer) > 0:
    print(answer)
else:
    print("PREDAJA")
