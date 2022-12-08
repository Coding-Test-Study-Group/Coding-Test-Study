a, b, c = map(int, input().split())

def recur(a, b, c):
    if b == 1: # base condition
        return a % c

    val = recur(a, b//2, c) # a^(b/2) % c
    result = val * val % c # result = a^b % c
    if b % 2 == 0: # 지수가 짝수 일 경우
        return result # a^(2*b*0.5) % c
    elif b % 2 == 1:
        return result * a % c # a^(2*b*0.5 +1) % c

print(recur(a, b, c))