def solution(n, results):
    answer = 0
    
    #1. 그래프 생성 및 초기화
    #2. 그래프 순회하며 dfs 실행
    #   도착점인 점들이 방문하지 않은 경우,
    #   arr추가 및 dfs 탐색
    #3. 그래프를 순회하면서 시작점인 경우, 도착점인 경우를 세주기
    #4. cnt배열의 개수가 ,n-1개인 경우 만족하는 경우 answer+=1 해주기

    
    g = [[] for _ in range(n+1)]
    v = [0]*(n+1)
    cnt = [0] * (n+1)
    
    #그래프 초기화
    for i in results:
        g[i[0]].append(i[1])


    
    # 도착점인 점들이 방문하지 않은 경우,
    # arr추가 및 dfs 탐색
    def dfs(start,arr):
        
        for i in g[start]:
            if v[i]==0:
                arr.append(i)
                v[i]=1
                dfs(i,arr)
            
        return arr


    # 그래프 순회하며 방문 리스트 초기화 및 dfs 탐색     
    for i in range(1,n+1):
        v = [0]*(n+1)
        g[i] = dfs(i,[])

    #그래프를 순회
    for i in range(1,n+1):
        #i가 시작점인 개수를 더해주기
        cnt[i]+=len(g[i])
        for j in g[i]:
            #도착점인 경우를 더해주기
            cnt[j]+=1
    
    #cnt 배열을 순회하며
    # n-1을 만족하는 경우, answer+=1 해주기
    for i in range(1,n+1):
        if cnt[i]==n-1:
            answer+=1
    

    return answer