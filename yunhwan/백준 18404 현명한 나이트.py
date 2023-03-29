from collections import deque
#n x n 체스판 
# m개의 위치값이 주어졌을 때, 상대편 말을 잡기 위한 나이트 최소 이동 수

#1. 그래프 및 방문 그래프 생성
#2. 나이트 위치 1, 상대편 말 위치 2로 그래프 값 설정
#3. bfs 실행하며 나이트 이동 위치를 탐색
#4. 나이트 이동 위치가 범위내에 있고 방문한적이 없는 경우:
#   나이트 이동위치가 상대편 말 위치인 경우 cnt로 그래프값 설정
#   큐에 위치와 cnt+1 추가 후에 방문 처리
#5. 상대편 말들의 그래프 값 출력



#입력
n,m = map(int,input().split())
K = list(map(int,input().split()))
E = [list(map(int,input().split())) for _ in range(m)]

g = [[0]*(n+1) for _ in range(n+1)]
v = [[0]*(n+1) for _ in range(n+1)]

#나이트의 이동 위치
move = [[-2,-1],[-2,1],[-1,-2],[-1,2],[1,-2],[1,2],[2,-1],[2,1]]

# 그래프 값 설정
g[K[0]][K[1]] = 1


for i in E:
  g[i[0]][i[1]]=2

#bfs
def bfs(x,y):
  q = deque()
  q.append((x,y,1))
  v[x][y]=-1
  
  while(q):
    cx,cy,cnt = q.popleft()
    
    for i in range(8):
      dx = cx + move[i][0]
      dy = cy + move[i][1]

      if 0<dx<=n and 0<dy<=n:
        #방문 확인
        if v[dx][dy] ==0:
          if g[dx][dy] == 2:
            g[dx][dy]=cnt
          q.append((dx,dy,cnt+1))
          v[dx][dy]=-1
        
bfs(K[0],K[1])

for i in E:
  print(g[i[0]][i[1]],end=' ')