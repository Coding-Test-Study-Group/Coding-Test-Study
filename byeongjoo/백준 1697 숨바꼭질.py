"""

수빈이 : N
동생 : K

수빈이 이동 방법 : X-1, X+1, 2*X

"""
from collections import deque

n, k = map(int, input().split())

dist = [(-1)] * 100002

dist[n] = 0 # 초기값 설정
q = deque()
q.append(n)

while dist[k] == -1:
    x = q.popleft()
    for i in (x-1, x+1, 2*x):
        nx = i

        if nx < 0 or nx >100000:
            continue

        if dist[nx] != -1:
            continue

        dist[nx] = dist[x] + 1
        q.append(nx)

print(dist[k])