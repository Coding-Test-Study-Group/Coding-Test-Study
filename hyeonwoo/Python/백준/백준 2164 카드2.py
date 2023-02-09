import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

arr = [_ for _ in range(1, n + 1)]

dq = deque(arr)

while len(dq) > 1:
    dq.popleft()

    target = dq.popleft()
    dq.append(target)

print(*dq)
