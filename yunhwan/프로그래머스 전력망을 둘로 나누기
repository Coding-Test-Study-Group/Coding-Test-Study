from collections import deque

def solution(n, wires):
    answer = n
    g = [[] for _ in range(n+1)]
    v = [0] *(n+1)
    #그래프로 나타내주기
    for i in wires:
        g[i[0]].append(i[1])
        g[i[1]].append(i[0])
        

    #연결되어 있는 송전탑 개수 세주기
    def bfs(x):
        q =deque()
        q.append(x)
        v[x]=1
        cnt=1
        while(q):
            cx = q.popleft()
            for i in g[cx]:
                if v[i]==0:
                    q.append(i)
                    v[i]=1
                    cnt+=1
        return cnt
    

    for i in wires:
        #방문리스트 초기화
        v = [0] *(n+1)
        #print(i[0],i[1])
        #삭제
        g[i[0]].remove(i[1])
        g[i[1]].remove(i[0])

        answer =min(abs(bfs(i[0])-bfs(i[1])),answer)
        #원상복구
        g[i[0]].append(i[1])
        g[i[1]].append(i[0])
        
        

    return answer