# 아이템이 중복되는 경우를 체크하기 위한 변수를 두고 해당 변수와 Arr[i] 의 요소가 다르면 그 요소를 중복체크 용으로 변환하고 해당 요소는 결과에 삽입,
# 중복체크 변수와 Arr[i]가 같으면 아무것도 하지 않게 구성

def solution(arr):
    answer = []
    checkNum = -1
    
    for item in  arr:
        if checkNum != item:
            checkNum = item
            answer.append(item)
        
    return answer