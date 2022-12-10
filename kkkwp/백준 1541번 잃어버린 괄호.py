exp = input().split('-')
answer = 0

# 1번째 숫자는 음수일 수도, 양수일 수도 있으므로 따로 처리
for num in exp[0].split('+'):
    answer += int(num)

for s in exp[1:]:
    for num in s.split('+'):
        answer -= int(num)
print(answer)