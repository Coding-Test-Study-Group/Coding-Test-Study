def solution(phone_book):
    answer = True
    
    #정렬
    phone_book.sort()
    
    #순회
    for i in range(len(phone_book)-1):
        #현재 전화번호의 길이만큼, 다음문자열 자르기
        #자른 다음 전화번호에 있는지 확인
        if phone_book[i] in phone_book[i+1][:len(phone_book[i])]:
            return False
    
    
    return answer