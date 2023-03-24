import sys
input = sys.stdin.readline

exp = input().split('-')
answer = 0

for i in exp[0].split('+'):
    answer += int(i)

for s in exp[1:]:
    for num in s.split('+'):
        answer -= int(num)

print(answer)