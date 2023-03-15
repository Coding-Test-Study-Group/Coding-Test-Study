import itertools
def solution1(nums):
    answer = 0
    # 조합의 결과를 list로 
    temp = list(itertools.combinations(nums, 3))
    
    def sosu(n):
        # 소수 n을 2 부터 n의 제곱근까지 나눴을 때 나누어 떨어지지 않는다.
        for i in range(2, int(n ** 1/2) + 1):
            if n % i == 0:
                return False
        return True
    
    # 모든 조합의 경우의 수에 대해서 sum(item)으로 각 조합의 경우의 수의 합이 소수라면 answer + 1
    for item in temp:
        if sosu(sum(item)) == True:
            answer += 1

    return answer


def solution2(nums):
    answer = []
    
    # 소수 판별식
    def sosu(n):
        # 소수 n을 2 부터 n의 제곱근까지 나눴을 때 나누어 떨어지지 않는다.
        for i in range(2, int(n ** 1/2) + 1):
            if n % i == 0:
                return False
        return True
    
    # 조합(백트레킹) - 배열, 배열의 시작 index, 배열의 길이, 조합할 요소의 수, 
    # 현재 조합의 경우에서 한 번은 선택된 요소들의 모임
    def combination(arr, start, length, x, selected):
        # 현재 요구된 모든 조합의 수를 골랐을 때
        if x == 0:
            # 소수 판단 후 해당 수를 append 하고 return
            if sosu(sum(selected)):
                answer.append(sum(selected))
            return 
        # 배열의 현재 index 부터 끝까지 체크
        for i in range(start, length):
            # 배열에서 현재 조합 중인 i번째 요소를 selected(현재 조합에 사용된 요소) 에 추가
            selected.append(arr[i])
            # 재귀로 조합인 x개를 골랐을 때 소수인지 판단하기 위해서 
            # nums 와 현재 고른 다음의 요소의 index인 i + 1, 하나를 골랐으므로 x -1,
            # 현재까지 고른 요소의 모임을 매개변수로 호출
            combination(arr, i + 1, length, x - 1, selected)
            #combination() retrun 후 마지막에 선택된 요소 pop 하고 다음 요소로 이동
            selected.pop()
        
    combination(nums, 0, len(nums), 3, [])
    answer = int(len(answer))
    return answer