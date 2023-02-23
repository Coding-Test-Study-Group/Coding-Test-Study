def getDivisor(n):
    cnt = 0
    sqrt = int(pow(n, 1/2))
    for i in range(1, sqrt + 1):
        if n % i == 0:
            cnt += 1
    return cnt * 2 - 1 if pow(sqrt, 2) == n else cnt * 2

def solution(number, limit, power):
    answer = 0
    for num in range(1, number + 1):
        p = getDivisor(num)
        answer += power if p > limit else p
    return answer