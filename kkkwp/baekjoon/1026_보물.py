import sys
input = sys.stdin.readline

n = int(input())
a = sorted(list(map(int, input().split())), reverse=True)
b = sorted(list(map(int, input().split())))

print(sum([a[i] * b[i] for i in range(n)]))