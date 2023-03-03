# https://school.programmers.co.kr/learn/courses/30/lessons/147355
def solution(t, p):
    answer = 0

    for i in range(len(t)):
        # 문자열 t 를 0 부터 len(p) + i 만큼 슬라이싱 -> t에 대한 인덱싱 시작을 0 부터 i 까지 길이는 len(p) 만큼 유지하기 위해서
        # 이 길이가 len(p) 와 같을 때까지 (문자열에 끝에 다다를 수록 len(p) 보다 작아짐 len(p) + i > len(p) 인 경우 부터는 인덱싱에 무시(t의 끝까지만))
        # 이 때 t를 인덱싱한 길이가 len(p) 과 같고 p 보다 작으면 count ++
        if len(t[i:len(p)+i]) == len(p) and int(t[i:len(p)+i]) <= int(p):
            answer += 1
            
    return answer