from collections import deque
import sys

input = sys.stdin.readline

n, k = map(int, input().split())

arr = [_ for _ in range(1, n + 1)]
queue = deque(arr)

cnt = 1
result = []
while len(queue) > 0:
    target = queue.popleft()

    if cnt % k == 0:
        result.append(target)
    else:
        queue.append(target)

    cnt += 1

print("<", end="")
print(*result, sep=", ", end="")
print(">")
