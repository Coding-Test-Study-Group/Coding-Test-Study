def solution(prices):
    answer = []
    for i in range(len(prices) - 1):
        # 초기화
        sec = 0
        for j in range(i, len(prices) - 1):
            if(prices[i] <= prices[j]):
                sec += 1
            #prices[i]가 더 큰 경우는 중단
            else:
                break
        answer.append(sec);
    
    #마지막 값은 0
    answer.append(0);
    return answer