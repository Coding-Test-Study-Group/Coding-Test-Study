"""
R : 행
C : 열

#: 벽
.: 지나갈 수 있는 공간
J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
F: 불이 난 공간
"""
from collections import deque
import sys

input = sys.stdin.readline

r, c = map(int,input().split())
board = []

dx = [0,0,1,-1]
dy = [1,-1,0,0]

# 지훈이 거리
dist1 = [[0] * c for _ in range(r)]
q1 = deque()
# 불 거리
dist2 = [[0] * c for _ in range(r)]
q2 = deque()

for _ in range(r):
    board.append(list(char for char in input().rstrip()))

for i in range(r):
    for j in range(c):
        if board[i][j] == "J":
            q1.append((i,j))
            dist1[i][j] = 1
        if board[i][j] == "F":
            q2.append((i,j))
            dist2[i][j] = 1

# 불 bfs
# 불의 이동거리를 먼저 구한 후 지훈이의 이동범위를 구해야함.
while q2:
    x, y = q2.popleft()
    for direction in range(4):
        nx = x + dx[direction]
        ny = y + dy[direction]

        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            continue

        if dist2[nx][ny] != 0 or board[nx][ny] == "#":
            continue

        dist2[nx][ny] = dist2[x][y] + 1
        q2.append((nx, ny))


# 지훈이 bfs
while q1:
    x, y = q1.popleft()
    for direction in range(4):
        nx = x + dx[direction]
        ny = y + dy[direction]

        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            print(dist1[x][y])
            exit(0)

        if dist1[nx][ny] != 0 or board[nx][ny] == "#":
            continue

        if dist2[nx][ny] != 0 and dist2[nx][ny] <= dist1[x][y]+1 :#불이 이동했는데 불의 이동시간이 지훈이의 이동시간보다 작거나 같다면 지훈이는 움직일 수 없음.
            continue                                              #또한 불이 움직이지 않은거리는 무조건 지훈이 이동시간보다 값이 낮을테니 조건문에 잡아줘야함.

        dist1[nx][ny] = dist1[x][y] + 1
        q1.append((nx, ny))

print("IMPOSSIBLE")