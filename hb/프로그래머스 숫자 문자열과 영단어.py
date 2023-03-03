import re
def solution(s):
    # 문자열 그대로 입력받고 다시 정수로 변환하려고
    answer = ""
    
    # 제한속도 때문에 dict 사용
    number = {'0':"zero", '1':"one", '2':"two", '3':"three", '4':"four", '5':"five",
              '6':"six", '7':"seven", '8':"eight", '9':"nine"}
    
    # value 로 key 접근하려고 number dict 뒤집기
    rnumber = dict(map(reversed, number.items()))
    
    # s문자열 하나씩 입력받으려고
    temp = ""

    for i in range(len(s)):
        # 문자열 하나씩 입력 받아서
        temp += s[i]
        
        # temp 가 number 의 value에 해당 되면
        if temp in list(number.values()):
            # value 가지고 key 값 answer 에 추가
            answer += rnumber[temp]
            # temp 초기화
            temp = ""
        # temp 가 number 의 key에 해당되면
        elif temp in list(number.keys()):
            # key 값 answer에 그대로 추가(숫자니까)
            answer += temp
            # temp 초기화
            temp = ""
    answer = int(answer) # 완성된 숫자로만 구성된 문자열 정수형으로 변환
    return answer