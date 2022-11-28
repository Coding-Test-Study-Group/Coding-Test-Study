from collections import deque

n, m = map(int,input().split())

board = []
visited = [[0] * m for _ in range(n)]

for _ in range(n):
    board.append(list(map(int, input().split())))

num = 0 # 그림의 개수
maxDraw = 0 # 그림 최대값

dx = [0,1,0,-1]
dy = [1,0,-1,0]

for i in range(n):
    for j in range(m):
        if board[i][j] == 0 or visited[i][j] == 1:
            continue

        num += 1
        queue = deque()
        visited[i][j] = 1
        queue.append((i , j))
        area = 0 # 그림 넓이
        while queue:
            area +=1 # queue를 돌린만큼 1씩 가산
            x, y = queue.popleft()
            for direction in range(4):
                nx = x + dx[direction]
                ny = y + dy[direction]
                if nx <0 or ny <0 or nx >=n or ny>=m :
                    continue
                if visited[nx][ny] == 1 or board[nx][ny] == 0:
                    continue
                visited[nx][ny] = 1
                queue.append((nx,ny))

        maxDraw = max(maxDraw, area)

print(num)
print(maxDraw)