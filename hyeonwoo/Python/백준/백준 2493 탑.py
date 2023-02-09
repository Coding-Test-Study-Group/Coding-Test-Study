import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

stack = []
result = []

for i in range(n):
    while True:
        if not stack:
            result.append(0)
            break

        target = arr[i]

        idx = stack[-1][0]
        top = stack[-1][1]

        if target > top:
            stack.pop()

        if target <= top:
            result.append(idx + 1)
            break

    stack.append((i, arr[i]))

print(*result, sep=' ')
