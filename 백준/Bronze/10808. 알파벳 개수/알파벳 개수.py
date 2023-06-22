import sys

freq_dict = dict()

for i in range(97, 123):
    freq_dict[chr(i)] = 0

input_str = sys.stdin.readline().strip()
for char in input_str:
    freq_dict[char] += 1

for freq in freq_dict:
    print(freq_dict[freq], end=' ')