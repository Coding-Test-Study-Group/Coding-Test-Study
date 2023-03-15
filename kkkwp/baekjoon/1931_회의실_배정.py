import sys
input = sys.stdin.readline

n = int(input())

meetings = []
for _ in range(n):
    start, end = map(int, input().split())
    meetings.append([start, end])

meetings.sort(key=lambda x: (x[1], x[0]))

answer = 0
cur = 0
for meeting in meetings:
    if meeting[0] >= cur:
        answer += 1
        cur = meeting[1]

print(answer)