from collections import deque
import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    queue = deque(map(int, input().split()))

    queue_idx = deque([_ for _ in range(n)])

    # 몇 번째로 인쇄되었는지 궁금한 문서
    queue_idx[m] = "doc"

    cnt = 0
    while True:
        # 현재 문서의 중요도가 가장 높다면
        if queue[0] == max(queue):
            cnt += 1

            if queue_idx[0] == "doc":
                print(cnt)
                break

            else:
                queue.popleft()
                queue_idx.popleft()

        else:
            queue.append(queue.popleft())
            queue_idx.append(queue_idx.popleft())
