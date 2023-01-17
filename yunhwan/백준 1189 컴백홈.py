r, c, k = map(int,input().split())

graph = [str(input()) for _ in range(r)]
v = [[0]*c for _ in range(r)]
ans=0

#상하좌우 방향
dx = [-1,1,0,0]
dy = [0,0,-1,1]


def dfs(x,y,direct):
  global ans
  # 종료위치이고 거리가 k일 때
  if x==0 and y==c-1 and k==direct:
    ans+=1
    return True

  # 4방향
  for i in range(4):
    nx = x +dx[i]
    ny = y +dy[i]

    # 이동할 수 있는 위치일 때
    if r > nx >=0 and c> ny >=0 and graph[nx][ny]=='.':
      # 방문한 적이 없을 때
      if v[nx][ny] == 0:
        #방문처리
        v[nx][ny]=1
        #dfs
        dfs(nx,ny,direct+1)
        #방문처리 해제
        v[nx][ny]=0

# 시작 위치 방문 처리
v[r-1][0] =1
dfs(r-1,0,1)

print(ans)