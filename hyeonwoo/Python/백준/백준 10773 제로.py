import sys

input = sys.stdin.readline

k = int(input())

stack = []
for i in range(k):
    n = int(input())

    if n == 0:
        stack.pop()

    if n != 0:
        stack.append(n)

print(sum(stack))
