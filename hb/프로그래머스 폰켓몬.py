# https://school.programmers.co.kr/learn/courses/30/lessons/1845
def solution(nums):
    answer = 0
    temp = []
    if len(nums) > 10000 and len(nums) % 2 == 1:
        answer = False
    else: 
        # 결국 폰켓몬의 종류 상관없이 최대 개수만을 요구하는 문제
        # 최대로 고를 수 있는 폰켓못의 개수는 결국 (len(nums) // 2) 이므로 set 으로 nums 의 중복된 값을 제거
        # 다시 list 로 변환하고 (len(nums) // 2) 만큼만 인덱싱한 list 의 길이 자체가 최대로 선택할 수 있는 폰켓몬의 개수가 된다.
        temp = list(set(nums))[:len(nums) // 2]
        answer = len(temp)
    return answer