import collections
import sys

input = sys.stdin.readline

n = int(input())

dq = collections.deque()

for _ in range(n):
    cmd = str(input().rstrip())

    if cmd.startswith("push"):
        cmd, num = map(str, cmd.split())

        if cmd.endswith("front"):
            dq.appendleft(int(num))

        if cmd.endswith("back"):
            dq.append(int(num))

    if cmd.startswith("pop_front"):
        if dq:
            print(dq.popleft())
            continue

        if not dq:
            print(-1)

    if cmd.startswith("pop_back"):
        if dq:
            print(dq.pop())
            continue

        if not dq:
            print(-1)

    if cmd.startswith("size"):
        print(len(dq))

    if cmd.startswith("empty"):
        if dq:
            print(0)
            continue

        if not dq:
            print(1)

    if cmd.startswith("front"):
        if dq:
            print(dq[0])
            continue

        if not dq:
            print(-1)

    if cmd.startswith("back"):
        if dq:
            print(dq[-1])
            continue

        if not dq:
            print(-1)
