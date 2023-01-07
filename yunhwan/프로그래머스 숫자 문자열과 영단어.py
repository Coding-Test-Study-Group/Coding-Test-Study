def solution(s):
    answer = 0
    # 딕셔너리에 넣어주기
    dic = {}
    dic[0] = 'zero'
    dic[1] = 'one'
    dic[2] = 'two'
    dic[3] = 'three'
    dic[4] = 'four'
    dic[5] = 'five'
    dic[6] = 'six'
    dic[7] = 'seven'
    dic[8] = 'eight'
    dic[9] = 'nine'

    # replace로 변환
    for i in range(0, 10):
        s = s.replace(dic[i], str(i))

    answer = int(s)

    return answer