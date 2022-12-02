"""
입력
M, N, H : 가로 세로 높이
M은 열
N은 행
H은 3차원 시작 idx

1 -> 익은 토마토
0 -> 익지 않은 토마토
-1 -> 토마토 없음.

N개의 줄이 H번 반복함.
"""

from collections import deque
import sys

input = sys.stdin.readline

m, n, h = map(int, input().split())
board = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
dist = [[[0 for i in range(m)] for i in range(n)] for i in range(h)]

dx = [1,-1,0,0,0,0]
dy = [0,0,1,-1,0,0]
dz = [0,0,0,0,1,-1]

queue = deque()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if board[i][j][k] == 1:
                queue.append((i, j, k))
            if board[i][j][k] == 0:
                dist[i][j][k] = -1

while queue:
    x, y, z = queue.popleft()
    for direction in range(6):
        nx = x + dx[direction]
        ny = y + dy[direction]
        nz = z + dz[direction]
        if 0 > nx or nx >= h or 0 > ny or ny >= n or 0 > nz or nz >= m :
            continue
        if dist[nx][ny][nz] >= 0:
            continue
        dist[nx][ny][nz] = dist[x][y][z] + 1
        queue.append((nx, ny, nz))

ans = 0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if dist[i][j][k] == -1:
                print(-1)
                exit(0)

            ans = max(ans , dist[i][j][k])

print(ans)