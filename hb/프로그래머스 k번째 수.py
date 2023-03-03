# https://school.programmers.co.kr/learn/courses/30/lessons/42748
def solution(array, commands):
    answer = []
    temp1 = []
    temp2 = []
    for item in commands:
        # 문자열[x : y] -> x-1 index(x번째) 부터 index y 까지를 의미 
        # Commands[0] - 1 의 값 index 부터 commands[1]의 값의 index 까지 인덱싱
        temp1 = array[item[0]-1 : item[1]]
        temp1.sort() # 정렬
        temp2 = temp1[item[2] - 1]
        answer.append(temp2)
    return answer