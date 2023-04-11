def solution(routes):
    answer = 0
    routes.sort()
    n =len(routes)
    v = [0]*n
    #진입 , 진출 사이에 카메라 설치
    #모든 차량이 카메라를 한 번이라도 만날 경우
    #설치해야 하는 카메라의 최소개수
    
    for i in range(n):
        if v[i]==1:
            continue
        start = routes[i][0]
        end =routes[i][1]
        
        for j in range(i+1,n):
            if v[j]==1:
                continue
            if start <=routes[j][0]<=end:
                start = routes[j][0]
                v[j]=1
            if start<=routes[j][1]<=end:
                end = routes[j][1]
                v[j]=1
        answer+=1
    
    
    return answer