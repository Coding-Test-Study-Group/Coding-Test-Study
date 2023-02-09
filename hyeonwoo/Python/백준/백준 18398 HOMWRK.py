import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())

    for _ in range(n):
        a, b = map(int, input().split())

        print(a + b, a * b, sep=" ")
