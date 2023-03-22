def solution(record):
    answer = []
    dic_id = {}
    
    #1. record를 띄어쓰기 기준으로 나눠주기
    #2. record_list를 순회
    #3. uid에 따른 닉네임을 딕셔너리에 저장 및 갱신
    #4. record_list를 순회하며 결과추가
    
    #record를 띄어쓰기 기준으로 나눠주기
    record_list = [ record[i].split(' ') for i in range(len(record))]
    
    #record_list를 순회
    for i in record_list:
        #uid에 따른 닉네임을 딕셔너리에 저장 및 갱신
        if i[0]=='Enter' or i[0]=='Change' :
            dic_id[i[1]] = i[2]
            
    #record_list를 순회하며 결과추가    
    for i in record_list:
        if i[0]=='Enter':
            answer.append(dic_id[i[1]]+ '님이 들어왔습니다.')
        if i[0]=='Leave':
            answer.append(dic_id[i[1]]+ '님이 나갔습니다.')
    
    return answer