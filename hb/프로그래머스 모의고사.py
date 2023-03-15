
def solution(answers):
    # 수포자 1, 2, 3 이 정답을 맞힌 횟수를 기억하기 위한 list
    temp = [0, 0, 0]
    answer = []
    # 각 수포자의 정답을 찍는 패턴
    supo1 = [1, 2, 3, 4, 5]
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4 ,5, 5]
    
    # enumerate 로 answers (실제 정답) 의 index 와 값을 순회
    for item in enumerate(answers):
        # answers 의 현재 문제 번호의 답과 현재 문제 번호에 대한 수포자 x의 정답이 같을 때 count ++
        # item[1] 은 현재 번호의 실제 정답의 값, item[0] 은 현재 문제의 번호 -> 문제 번호는 0부터 시작한다고 생각
        # % 계산은 각 수포자의 정답을 찍는 패턴이 각자 5, 8, 10 개를 계속 반복하는 패턴을 가지므로
        # 문제의 개수가 각각의 패턴 보다 길어도 % 연산을 하면 계속 패턴 내에서 찾게 된다.
        if item[1] == supo1[item[0] % 5]: 
            temp[0] += 1
            
        if item[1] == supo2[item[0] % 8]:
            temp[1] += 1
            
        if item[1] == supo3[item[0] % 10]:
            temp[2] += 1
    
    # 정답 출력이 수포자 1이 가장 많이 맞추면 [1], 수포자 1과 3 이 동일하게 정답을 맞춘개수가 많으면 [1,3]
    # 셋다 정답을 맞춘 횟수가 같다면 [1, 2, 3] 과 같이 출력해야 하므로  
    # 각 수포자의 정답 횟수를 저장한 temp 를 enumerate 로 순회해서 item[1](각 수포자의 정답 횟수) 를 
    # max(temp) 수포자 누구든가장 많이 맞춘 횟수와 비교해서 같을 때 수포자 번호는 1 부터 시작하고 item[0]은 0부터 시작하므로
    # answer에 item[0] + 1 을 추가
    for item in enumerate(temp):
        if item[1] == max(temp):
            answer.append(item[0] + 1)
        
    return answer