import sys
input = sys.stdin.readline

n = int(input())

ropes = []
for _ in range(n):
    ropes.append(int(input()))

ropes.sort(reverse=True)

answer = 0
for i in range(n):
    weight = ropes[i] * (i + 1)
    if weight > answer:
        answer = weight

print(answer)