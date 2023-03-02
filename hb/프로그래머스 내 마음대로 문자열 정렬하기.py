
def solution(strings, n):
    answer = []
    key = []
    
    # strings 배열자체의 크기 유효성 검사
    if len(strings) < 1 or len(strings) > 50:
        answer = "strings 배열의 길이가 잘못 되었습니다."
    
    for item in strings:
        # strings 배열 요소의 길이 유효성 검사
        if len(item) < 1 or len(item) > 100:
            answer = "strings 배열 요소의 길이가 잘못되어습니다."
        else:
            key.append(item[n])
    
    strings = list(tuple(zip(key, strings)))
    strings.sort(key=lambda x:(x[0], x[1]))
    
    for item in strings:
        answer.append(item[1])
            
    return answer