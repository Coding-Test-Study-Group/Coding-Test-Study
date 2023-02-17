if __name__ == '__main__': 
    records = []; # 전체를 받을 배열입니다.
    scores = []; # 점수를 받을 배열입니다. 
    for _ in range(int(input())):
        name = input()
        score = float(input())
        records.append([name, score]) # 이름과 점수를 입력받아 배열에 넣습니다.
        scores.append(score) # 점수만 넣습니다.
    
    scores = list(set(scores)) # 정렬을 위해 list로 선언합니다.
    scores.sort(); # 정렬합니다. - 파이썬의 list.sort() 메소드는 Tim Sort를 사용합니다.
    scoreAnswer = scores[1]; # 2번째로 높은 값을 찾기위해 정렬된 값의 1번 인덱스를 취합니다.
    
    names = []; # 대상의 이름을 보관하기 위한 배열입니다.
    for i in records: # 전체 배열을 순회합니다.
        if (i[1] == scoreAnswer): # 2번째로 높은 값을 찾으면
            names.append(i[0]) # 해당 이름을 배열에 더합니다.
    
    names.sort(); # 알파벳 순으로 정렬합니다.
    
    for i in names:
        print(i) # 출력합니다.
