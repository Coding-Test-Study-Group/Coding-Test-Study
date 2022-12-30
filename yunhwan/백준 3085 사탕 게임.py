n = int(input())

input = [str(input())for _ in range(n)]
g = [[0]*n for _ in range(n)]

arrChange = []
ans = 0
dx = [1,0]
dy = [0,1]

# 그래프 생성
for i in range(n):
  for j in range(n):
    if input[i][j]=='C':
      g[i][j]=0
    elif input[i][j]=='P':
      g[i][j]=1
    elif input[i][j]=='Z':
      g[i][j]=2
    elif input[i][j]=='Y':
      g[i][j]=3

# 교환한 좌표의 행, 열을 기준
# 가장 길게 연결된 사탕 찾기
def findCandy(x,y):

  rowCnt = 1
  colCnt = 1
  tmp=1

  # 열 조사
  for i in range(1,n):
    if g[x][i] == g[x][i-1]:
        tmp+=1
    else:
        tmp=1
    if tmp>colCnt:
      colCnt=tmp

  #행 조사
  tmp= 1
  for j in range(1,n):
    if g[j][y] == g[j-1][y]:
        tmp+=1
    else:
        tmp=1
    if tmp>rowCnt:
        rowCnt=tmp

  # 둘 중 큰 값 반환
  return max(rowCnt,colCnt)

# 그래프 모든 행과 열 조사
for i in range(n):
  ans = max(ans ,findCandy(0,i),findCandy(i,0))

if ans==n:
  print(ans)
  exit(0)

# 바뀔 수 있는 값들을 모은 배열 생성
for i in range(n):
  for j in range(n):
    for k in range(2):
      nx = i+dx[k]
      ny = j+dy[k]
      if 0<=nx<n and 0<=ny<n:
        if g[nx][ny] != g[i][j]:
          arrChange.append([[i,j],[nx,ny]])

#바뀔 수 있는 값 순회
for i in range(len(arrChange)):
  # 값 설정
  fx,fy = arrChange[i][0]
  sx,sy = arrChange[i][1]

  # 값 교환, 좌표를 기준으로 조사, 원위치
  g[fx][fy], g[sx][sy] =  g[sx][sy],g[fx][fy]
  ans = max(ans,findCandy(fx,fy),findCandy(sx,sy))
  g[fx][fy], g[sx][sy] =  g[sx][sy],g[fx][fy]

print(ans)