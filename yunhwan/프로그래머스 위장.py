def solution(clothes):
    answer = 1
    dic = {}
    clothes_num = []

    # 종류별로 옷을 구분
    for i in clothes:      
        if i[1] not in dic:
            dic[i[1]] =[i[0]]
        else:
            dic[i[1]].append(i[0])
    

    for i in dic:
        # 옷 종류의 개수 + 1 의 조합          
        answer*= (len(dic[i])+1)

    #아무것도 입지 않는 경우 제외
    answer-=1
    return answer