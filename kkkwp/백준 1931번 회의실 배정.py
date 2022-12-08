n = int(input())

arr = []
for _ in range(n):
    start, end = map(int, input().split())
    arr.append([start, end])

arr.sort(key=lambda x: x[0])
arr.sort(key=lambda x: x[1])

answer = 0
last = 0
for start, end in arr:
    if last <= start:
        answer += 1
        last = end

print(answer)