def solution(n, times):
    answer = 0
    m = len(times)
    
    #입국 심사를 기다리는 최대 사람은 1억명
    #이분탐색을 활용하는 문제
    

    sorted(times)
    
    start = 0
    end = times[-1] * n
    cnt=0
    
    #이분 탐색
    while start<=end:
        mid = (start+end)//2
        sum_arr = 0

        #mid 시간동안 가능한 명수 구하기
        for i in range(m):
            sum_arr += mid//times[i]
        
        # 심사한 사람의 수가 심사 받아야할 사람의 수(n)보다 적은 경우
        if sum_arr<n:
            start=mid+1
            
        # 심사한 사람의 수가 심사 받아야할 사람의 수(n)보다 많거나 같은 경우
        else:
            end = mid-1       
            answer=mid


    return answer