from collections import deque
import sys
input = sys.stdin.readline
t = int(input())

dx = [0,0,1,-1]
dy = [1,-1,0,0]

for _ in range(t):
    w, h = map(int, input().split())
    board = []

    #불
    q1 = deque()
    visit1 = [[0] * w for _ in range(h)]
    #상근이
    q2 = deque()
    visit2 = [[0] * w for _ in range(h)]


    for _ in range(h):
        board.append(list(input()))

    for i in range(h):
        for j in range(w):
            if board[i][j] == "*":
                q1.append((i,j))
                visit1[i][j] = 1

            if board[i][j] == "@":
                q2.append((i,j))
                visit2[i][j] = 1

    #불 bfs
    while q1:
        x, y = q1.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if nx < 0 or nx >=h or ny < 0 or ny >=w:
                continue

            if board[nx][ny] == "#" or visit1[nx][ny] != 0 :
                continue

            visit1[nx][ny] = visit1[x][y] + 1
            q1.append((nx, ny))

    impossible = True # impossible 내보내기
    doubleBreak = False # while 까지 탈출하기 위해 boolean 선언
    #상근이 bfs
    while q2:
        if doubleBreak:
            break
        x, y = q2.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if nx < 0 or nx >=h or ny < 0 or ny >=w:
                print(visit2[x][y])
                doubleBreak = True
                impossible = False
                break

            if board[nx][ny] == "#" or visit2[nx][ny] != 0:
                continue

            if visit1[nx][ny] != 0 and visit1[nx][ny] <= visit2[x][y]+1:
                continue

            visit2[nx][ny] = visit2[x][y] +1
            q2.append((nx,ny))
    if impossible:
        print("IMPOSSIBLE")