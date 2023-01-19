import math

a, b = map(int, input().split())
array = [1 for i in range(int(math.sqrt(b)) + 1)]  # 처음엔 모든 수가 소수(1)인 것으로 초기화
almost_prime = []
cnt = 0

# 에라토스테네스의 체 알고리즘
for i in range(2, int(math.sqrt(b)) + 1):  # 2부터 n의 제곱근까지의 모든 수를 확인하며
    if array[i] == 1:  # i가 소수인 경우 (남은 수인 경우)
        # i를 제외한 i의 모든 배수를 지우기
        j = 2
        while i * j <= int(math.sqrt(b)):
            # 소수가 아닌 수 설정
            array[i * j] = 0
            j += 1

for i in range(2, int(math.sqrt(b)) + 1):  # 2부터 n의 제곱근까지의 모든 수를 확인하며
    if array[i] == 1:  # i가 소수인 경우 (남은 수인 경우)
        j = 2
        # i를 제외한 i의 제곱을 세주기
        while i ** j <= b:
            # a이상 일때만 세주기
            if i ** j >= a:
                cnt += 1
            j += 1

print(cnt)