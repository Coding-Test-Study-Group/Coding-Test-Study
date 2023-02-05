def solution(babbling):
    words = ['aya', 'ye', 'woo', 'ma']
    answer = 0
    # 문자열 순회
    for i in babbling:
        # 인덱스 값 지정 및 이전단어 설정
        start, end = 0, 0
        prev = ''

        # 현재 문자열의 길이보다 작을 때만 실행
        while (end < len(i)):
            # start 재설정
            start = end

            # 현재단어와 일치하는지 확인 및 이전단어와 불일치 여부 확인
            # 조건 만족 시, end값 설정 및 prev 값 저장
            if i[start:start + 2] == words[1] and i[start:start + 2] != prev:
                end = start + 2
                prev = words[1]
            elif i[start:start + 2] == words[3] and i[start:start + 2] != prev:
                end = start + 2
                prev = words[3]
            elif i[start:start + 3] == words[0] and i[start:start + 3] != prev:
                end = start + 3
                prev = words[0]
            elif i[start:start + 3] == words[2] and i[start:start + 3] != prev:
                end = start + 3
                prev = words[2]
            else:
                break
        # 문제 조건을 만족하는 단어일 때, 개수 증가
        if end == len(i):
            answer += 1

    print(answer)

    return answer