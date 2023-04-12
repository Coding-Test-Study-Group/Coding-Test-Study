def solution(want, number, discount):
    answer = 0
    want_dic = {}
    n = len(discount)
    #회원 자격 10일
    #할인 제품은 하루에 하나
    # 정현이는 원하는 제품 할인 날자와 10일 연속 일치할 시 가입
    
    for i in range(n-9):
        flag = 1
        
        #want_dic 초기화
        for idx in range(len(number)):
            want_dic[want[idx]] = number[idx]
        
        #10일을 순회
        #딕셔너리에 포함된다면 해당 값 감소
        #포함되지 않으면 break
        for j in range(i,i+10):
            if discount[j] not in want_dic:
                flag=0
                break
            else:
                want_dic[discount[j]]-=1
                
        #조건 불충족 시              
        if flag==0:
            continue
            
        #딕셔너리의 값이 0인지 확인
        for idx in range(len(number)):
            if want_dic[want[idx]]!=0:
                flag=0
                break
                
        if flag==1:
            answer+=1
            
    return answer