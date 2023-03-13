def solution(elements):
    answer = 0
    

    n = len(elements)
    dp = [0]*(n+1)
    result= []


    
    #dp 생성
    for i in range(1,n+1):
        dp[i] = dp[i-1] + elements[i-1]
    
    #개수를 1부터 n까지 증가
    for l in range(1,n+1):
        # start는 0부터 n까지 증가
        for start in range(n):
    
            #end 원형 수열이기 때문에 n의 나머지로 설정
            end = (start+l) % (n)
            
            #start end 값에 따라 결과를 나눠줌
            if start<end :
                sum_elements =dp[end] -dp[start]
            elif start>end:
                sum_elements =dp[-1]-dp[start]+dp[end]
            else:
                sum_elements = dp[n]
            #result에 추가
            result.append(sum_elements)

    #set로 변경후에 개수 설정
    answer = len(set(result))
    return answer