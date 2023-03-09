# https://school.programmers.co.kr/learn/courses/30/lessons/1845
def solution(nums):
    answer = 0
    temp = []
    if len(nums) > 10000 and len(nums) % 2 == 1:
        answer = False
    else: 
        # 일단 가장 많은 종류를 얻기 위해 set으로 중복을 제거하고 그 중 [:len(nums) // 2]까지 슬라이싱
        # 중복을 제거했을 때 개수가 N/2보다 작으면 어쨌든 중복을 제거한 개수의 종류에 
        # 그 종류와 중복되는 A 만큼 더해서 N/2 마리를 가져가는 것이므로 종류의 개수는 어쨌든 중복을 제거한 만큼의 길이와 같다
        # 반대로 중복을 제거한 결과가 N/2 보다 많으면 그 중 N/2 마리를 아무렇게나 골라도 되는 것이고
        # 그 중 종류를 최대로 선택하는 것은 N/2 마리(len(nums) // 2)가 된다.
        temp = list(set(nums))[:len(nums) // 2]
        answer = len(temp)
    return answer