# https://school.programmers.co.kr/learn/courses/30/lessons/142086
def solution(s):
    answer = []
    # 빈 딕셔너리 생성
    dic = dict()
    
    # enumerate 로 s[i] 값과 i를 같이 순회 -> (0. s[0])
    # item -> (i, s[i]) 
    for item in enumerate(s):
        # 이 때 item[1] 즉 s[i] 에 해당되는 값이 dic에 없을 때 answer 에 -1 삽입
        if item[1] not in dic:
            answer.append(-1)
        
        # 아닌경우 즉, s[i] 가 dic에 있는 경우 현재 item[0] = i 현재 순회중인 문자열이 dic에 존재하는 경우
        # 이미 해당되는 문자 하나가 s 의 앞에 존재하는 경우
        # s 의 index(item[0) 에서 dic에 현재 저장된 key(s 하나하나를 자른 문자열)를 조회한 결과인 
        # 이전 순회 때 s에서 key(문자)에 해당되어 value로 저장한 해당 순회 번째의 문자가 가진 s 내의 index를 뺄샘하면
        # 바로 직전의 자신과 동일한 문자와 얼만큼 현재 자신(문자)가 떨어저 있는지 구하게 되고 그 값을 answer 에 추가
        else:
            answer.append(item[0] - dic[item[1]])
        
        # s[i] 즉 item[1] 을 key로 갖고 해당 순회의 문자(s[i])의 index를 value로 갖게 dic을 채운다.
        # 이 때 key(문자)는 중복될 수 없으므로 순회하면서 value에 index를 주면 key 에 해당되는 문자가 s에서 몇번째 index에 있는지
        # 기억하게 되고
        # 다음 순회 시 dic에 이미 key로 저장된 문자가 있을 때 key는 중복이 안되므로 value(현재 문자열의 index)만 갱신
        dic[item[1]] = item[0]
        
    return answer