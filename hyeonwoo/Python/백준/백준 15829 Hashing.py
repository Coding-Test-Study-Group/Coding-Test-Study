import sys

input = sys.stdin.readline

l = int(input())
arr = list(map(str, input().rstrip()))
m = 1234567891

result = 0
for i in range(l):
    result += (ord(arr[i]) - 96) * (31**i)

print(result % m)
