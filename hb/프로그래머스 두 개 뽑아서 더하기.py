# https://school.programmers.co.kr/learn/courses/30/lessons/68644
def solution(numbers):
    answer = []
    temp = []
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            # temp 에 number[i] + numbers[i+1] 을 out of index 를 방지하고 numbers 의 길이만큼 작업
            temp.append(numbers[i] + numbers[j])
    
    # set 으로 중복 제거 후 list 로 변환하고 오름차순으로 정렬해 answer에 반환
    answer = sorted(list(set(temp)))
    return answer