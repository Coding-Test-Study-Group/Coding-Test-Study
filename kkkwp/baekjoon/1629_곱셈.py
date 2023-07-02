import sys
input = sys.stdin.readline

def pow(a, b, c):
    # base condition
    # a가 c보다 클 수 있기 때문에 a를 리턴하는 대신 a % c를 리턴
    if b == 1:
        return a % c

    tmp = pow(a, b // 2, c)
    tmp = tmp * tmp % c

    # b가 짝수이면 그냥 tmp의 값을 반환하면 끝이지만 
    # b가 홀수이면 tmp에 a를 한번 더 곱해서 반환해야 함
    if b % 2 == 0:
        return tmp
    return tmp * a % c

a, b, c = map(int, input().split())
print(pow(a, b, c))
