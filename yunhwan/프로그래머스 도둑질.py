def solution(money):
    answer = 0
    n =len(money)
    
    #dp 생성
    #dp[i][0] 집을 안털 때, dp[i][1] 집을 털 때
    
    #원형 형태로 되어있기 때문에
    #첫 집을 털 경우인 dp, 첫 집을 털지 않은 경우인 dp2를 생성
    #첫 집을 털 경우에는 마지막 집을 털지 못함
    #첫 집을 털지 않을 경우 마지막 집을 터는 것은 선택
    #따라서 첫 집을 털 경우 마지막 집을 없다고 가정
    #첫 집을 털지 않을 경우 첫번째 집을 없다고 가정
    
    
    dp = [[0,0] for _ in range(len(money))]
    dp2 = [[0,0] for _ in range(len(money))]
    
    dp[0][0] = 0 
    dp[0][1] = money[0]
    
    dp2[1][0] = 0
    dp2[1][1] = money[1]
    
    
    for i in range(1, len(money)):
        # 두 번째 집부터 dp적용
        dp[i][0] = max(dp[i-1][0],dp[i-1][1])
        dp[i][1] = dp[i-1][0] + money[i]
        
        # 세 번째 집부터 dp2 적용
        if i>1:
            dp2[i][0] = max(dp2[i-1][0],dp2[i-1][1])
            dp2[i][1] = dp2[i-1][0] + money[i]
    
    #dp는 마지막 집이 존재하지 않기에 dp[-2]을 대상으로 비교
    #dp2는 마지막 집이 존재하기 때문에 dp[-1]을 대상으로 비교
    answer =max(dp[-2][0],dp[-2][1],dp2[-1][0],dp2[-1][1])
    
    
    return answer