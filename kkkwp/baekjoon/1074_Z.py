import sys
input = sys.stdin.readline

def z(n, r, c):
    # base condition
    if n == 0:
        return 0
    
    half = pow(2, n-1)
    # 1번 사각형일 때
    if r < half and c < half:
        return z(n - 1, r, c)
    # 2번 사각형일 때
    if r < half and c >= half:
        return half * half + z(n - 1, r, c - half)
    # 3번 사각형일 때
    if r >= half and c < half:
        return 2 * half * half + z(n - 1, r - half, c)
    # 4번 사각형일 때
    return 3 * half * half + z(n - 1, r - half, c - half )

n, r, c = map(int, input().split())
print(z(n ,r, c))
