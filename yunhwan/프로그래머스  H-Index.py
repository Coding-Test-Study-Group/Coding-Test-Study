def solution(citations):
    #citations=[10, 10, 10, 10, 10]
    #citations=[3,4,5,61,62,63,70,71,72,73]
    # 0 1 2 5 5 5 5 1000 8000 9000 10000 10001 10002
    # 3 4 5 61 62 63 70 71 72 73
    
    
    answer = 0
    #h인덱스
    # 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 
    # 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
    
    
    # 정렬 후 idx값을 통해서  
    # h개 이상 idx ~ len(citations)-1
    # 이중 큰 값
    
    n = len(citations)
    h_idx = 0 

    #정렬
    citations.sort()
    
    # 배열 순회
    for i in range(len(citations)):
        # h_idx 지정
        h_idx = citations[i]
        # h_idx번 인용된 논문이 h편 이상이면 pass
        if h_idx <= len(citations) - i:
            pass
        # 아닐 경우
        else:
            # 전부 동일한 경우 [10,10,10]
            if i==0:
                # 논문 개수 반환
                return n
            #이전 h_idx 와 이전 h_idx번보다 많이 인용된 논문의 개수
            #두 값 중 큰 값을 answer로 설정
            answer = max(citations[i-1],len(citations)-i)   
            break


    
    return answer