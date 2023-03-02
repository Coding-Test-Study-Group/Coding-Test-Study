import math
def solution(n, m):
    answer = []
    answer.append(math.gcd(n, m))
    answer.append(n*m // answer[0]) # 최소공배수 = X * Y / 최대공약수
    return answer