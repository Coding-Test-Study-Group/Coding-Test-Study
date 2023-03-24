import sys
input = sys.stdin.readline

n = int(input())
line = list(map(int, input().split()))

line.sort()

answer = 0
for i in range(n):
    answer += sum(line[:i+1])

print(answer)