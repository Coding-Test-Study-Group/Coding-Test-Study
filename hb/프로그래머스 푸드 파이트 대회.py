# https://school.programmers.co.kr/learn/courses/30/lessons/134240
def solution(food):
    answer = ''
    temp = []
    
    # 물의 개수는 언제나 1개
    if food[0] != 1:
        answer = "물의 개수가 잘못 되었습니다."
        
    # 음식 테이블에 올라가는 음식 개수는 최소 물과 합쳐서 3개가 되어야 한다.
    elif len(food) < 2 or len(food) > 9:
        answer = "준비된 음식의 개수가 잘못 되었습니다."
    else:
        # 물을 보관한 food 의 0번 째 index를 제외하고, 왼편테이블 먼저 생성
        for i in range(1, len(food)):
            # i 번째로 칼로리가 높은 만큼 i음식을 나열하는데, 음식은 두사람이 나눠 먹는다.
            # i 음식은 문자열 취급, 두사람이 나누기 때문에 음식 개수에 상관없이 못쓰는 음식 종류나 버리는 개수가 존재가능
            answer += str(i) * (food[i] // 2)
            
        temp = answer # 물 오른편의 테이블 생성을 위해 보관
        answer += "0" + temp[::-1] # 테이블에 물을 올리고 answer 을 뒤집어서 오른편 사람도 같은 순서로 음식을 먹게 한다.
    return answer