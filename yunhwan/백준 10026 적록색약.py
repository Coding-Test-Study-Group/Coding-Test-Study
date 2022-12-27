from collections import deque

n = int(input())

g = [str(input()) for _ in range(n)]
v = [[0] * n for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

rg,nrg = 0,0

def bfs(x, y, cnt):
    q = deque()
    q.append((x, y))
    v[x][y] = cnt

    while q:
      x,y = q.popleft()

      for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        #범위 확인
        if 0<=nx<n and 0<=ny<n:
          #방문 확인
          if v[nx][ny]==0:
            #같을 때
            if g[nx][ny]==g[x][y]:
              q.append((nx,ny))
              v[nx][ny]=cnt

# 구역의 수 찾기
def find():
  cnt=0
  for i in range(n):
    for j in range(n):
      if v[i][j]==0:
        cnt+=1
        bfs(i,j,cnt)
  return cnt


nrg = find()

# 적록색맹 설정 및 방문 초기화
for i in range(n):
  g[i] = g[i].replace('G','R')
v = [[0] * n for _ in range(n)]

rg = find()

print(nrg,rg)