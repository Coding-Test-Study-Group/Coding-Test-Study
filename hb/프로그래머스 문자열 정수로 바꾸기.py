# 문자열 맨앞 판별(-) 여부 이후 int형으로 맞게 변환
def solution(s):
    answer = 0
    operator = 1

    if(s[0] == "-"):
        operator = -1
        answer = operator * int(s[1:5])
    else:
        answer = int(s)

    return answer