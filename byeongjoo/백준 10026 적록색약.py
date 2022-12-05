from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
board= []
dx = [0,0,1,-1]
dy = [1,-1,0,0]

for _ in range(n):
    board.append(list(input()))

def bfs(visit, q): # BFS 함수
    while q:
        x, y = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if nx < 0 or nx >= n or ny < 0 or ny >= n :
                continue

            if visit[nx][ny] == 1 or board[x][y] != board[nx][ny]: # 이미 방문을 했거나 board 색깔이 바뀌는 지점이라면
                continue

            visit[nx][ny] = 1
            q.append((nx, ny))


def redGreen(isP): # 적록색약 구분 함수. 안에 bfs 넣을 것
    count = 0
    q = deque()
    visit = [[0] * n for _ in range(n)]
    if isP == 1: # 적록색약이라면 board 초록-빨강 합쳐주기
        for i in range(n):
            for j in range(n):
                if board[i][j] == "G":
                    board[i][j] = "R"

    for i in range(n):
        for j in range(n):
            if visit[i][j] != 0:
                continue
            q.append((i,j))
            visit[i][j] = 1
            bfs(visit, q)
            count+=1

    return count




print(redGreen(0), end= " ") # 적록 색약이 아닌 사람.
print(redGreen(1)) # 적록 색약인 사람.