import sys

input = sys.stdin.readline

n, m = map(int, input().split())

arr = [n for _ in range(n)]

result = "".join(map(str, arr))

if n >= m:
    print(result[:m])

if n < m:
    print(result)
