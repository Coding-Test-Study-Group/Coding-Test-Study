"""
hosu 변수를 단지로 읽어주시면 감사하겠습니다...
"""

from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]
n = int(input())
q = deque()
board=[]
hosu = 0 # 단지 개수
for _ in range(n):
    board.append(list(map(int, input())))
countList= [] # 각 단지마다 몇 채의 집이 있는지 개수 세기

for i in range(n):
    for j in range(n):
        if board[i][j] == 0: # 보드 안에 0으로 되어있는 부분 및 BFS 통해 개수가 세어진 호수를 제거하기 위한 목적
            continue

        q.append((i,j))
        board[i][j] = 0
        count = 1 # 현재 단지의 집 1채 추가
        hosu += 1 # 단지 카운트 증가
        while q: #BFS
            x, y = q.popleft()
            for d in range(4):
                nx = x + dx[d]
                ny = y + dy[d]

                if nx <0 or nx>= n or ny <0 or ny>=n:
                    continue

                if board[nx][ny] == 1: #만약 다음 집을 세지 않았다면
                    board[nx][ny] = 0 # 세기 편하기 위해 다음 집을 0으로 만들어주기 (방문확인 목적)
                    q.append((nx,ny)) # 다음 집을 queue에 삽입
                    count += 1 # 현재 단지의 집 1 채를 더 추가

        countList.append(count)

countList.sort() # 정렬

print(hosu)
for i in countList:
    print(i)