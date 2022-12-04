import sys

input = sys.stdin.readline

a, b = map(int, input().split())

set_a = set(map(int, input().split()))
set_b = set(map(int, input().split()))

result = set.symmetric_difference(set_a, set_b)
print(len(result))
