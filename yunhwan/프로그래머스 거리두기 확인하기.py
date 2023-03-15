from collections import deque

def solution(places):

    n = 5
    answer = [1]*n

    
    g =[[list(places[i][j])  for j in range(5)] for i in range(n)]
    v = [[[0]*n for j in range(n)] for i in range(n)]
    
    dx =[-1,0,1,0]
    dy =[0,1,0,-1]
    
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if g[i][j][k]=='X':
                    v[i][j][k]=1
    
    def bfs(idx,x,y):
        q = deque()
        q.append((x,y))
        v[idx][x][y] = 1

        while(q):
            x,y = q.popleft()
            cnt = 0 
            for i in range(4):
                nx = x+dx[i] 
                ny = y+dy[i]
                
                # 범위내에 존재
                if 0<=nx<n and 0<=ny<n:
                    #사람이고 주위에 사람이 있을경우
                    if  g[idx][x][y]=='P' and g[idx][nx][ny]=='P':
                            return False
                    
                    # 빈 테이블이고 주위에 사람이 있을경우
                    if  g[idx][x][y]=='O' and g[idx][nx][ny]=='P':
                            cnt+=1
                            if cnt>=2:
                                return False
                    #방문한적이 없는 경우, 큐에 추가
                    if v[idx][nx][ny]==0:
                        q.append((nx,ny))
                        v[idx][nx][ny]=1
                
        return True
        
    for i in range(n):        
        for j in range(n):   
            for k in range(n):
                if v[i][j][k]==0:
                    if bfs(i,j,k)==False:
                        answer[i]=0
                        print(answer)
                        break
                        
            if answer[i]==0:
                break

            
    return answer