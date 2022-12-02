# 최대공약수
def gcd(a, b):
    if a % b == 0:
        return b
    return gcd(b, a % b)

# 최소공배수
def lcm(a, b):
    return a * b // gcd(a, b)

def solution(arr):
    arr.sort(reverse=True)
    answer = 1
    for num in arr:
        answer = lcm(num, answer)
    return answer