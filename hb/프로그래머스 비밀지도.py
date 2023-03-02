def solution(n, arr1, arr2):
    answer = []
    temp = []
    # 유효성 검사
    if n < 1 or n > 16:
        answer.appen("배열의 길이가 잘못되었습니다.")
        
    # arr1, arr2 를 하나의 리스트로 합침
    for item in arr1, arr2:
        for i in range(n):
            # 유효성 검사
            if item[i] < 0 or item[i] > 2 ** n - 1:
                answer.appen("배열의 요소의 크기가 잘못되었습니다.")
                break;
            
            temp.append(item[i])
    
    # arr1, arr2 의 요소를 하나로 합치는 과정에서 발생하면 break 로 인해 정상 실행 시 temp 의 길이인 n * 2 -1 보다 짧기 
    # 때문에 유효성 검사 불통으로 중단.
    for i in range(n):
        if len(temp) < n * 2 - 1: 
            break;
        
     
        answer.append(bin(temp[i] | temp[i+n])[2:])
        
        # 이 때 arr1, arr2 or 연산 값(answer[i])의 길이가 n 보다 작으면 " "을 확인하기 위해서 짧은 만큼 앞에 0 추가 
        if len(answer[i]) < n:
            answer[i] = "0" * (n - len(answer[i])) + answer[i]
        
        # answer[i] 마다 1은 #, 0 은 ' ' 으로 변환
        answer[i] = str(answer[i]).replace('1', '#')
        answer[i] = str(answer[i]).replace('0', ' ')

    return answer