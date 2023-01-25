n = int(input())

arr = [int(input()) for i in range(n)]

plus = []
minus = []

result1 = 0
result2 = 0

for i in range(n):
    if arr[i] > 0:
        plus.append(arr[i])
    else:
        minus.append(arr[i])

plus.sort(reverse=True)
minus.sort()

for i in range(0, len(plus), 2):
    # 묶고 남은 수 일 때
    if i + 1 == len(plus):
        result1 += plus[i]

    # 묶이는 수 중에 1이 있을 때
    elif plus[i + 1] == 1:
        result1 += (plus[i] + 1)

    # 그 외 묶일 때는 두수의 곱 더하기
    else:
        result1 += (plus[i] * plus[i + 1])

for i in range(0, len(minus), 2):
    # 묶고 남은 수 일 때
    if i + 1 == len(minus):
        result2 += minus[i]
    # 그 외 묶일 때는 두수의 곱 더하기
    else:
        result2 += (minus[i] * minus[i + 1])

print(result1 + result2)