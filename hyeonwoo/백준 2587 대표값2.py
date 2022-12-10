import sys

input = sys.stdin.readline

arr = [int(input()) for _ in range(5)]

print(sum(arr) // 5)
print(sorted(arr)[2])
