import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

m = int(input())
target = list(map(int, input().split()))

dict = {}
for i in arr:
    if i in dict.keys():
        dict[i] += 1
    else:
        dict[i] = 1

result = []

for i in target:
    if i in dict.keys():
        result.append(dict.get(i))
    else:
        result.append(0)

print(*result, sep=" ")
