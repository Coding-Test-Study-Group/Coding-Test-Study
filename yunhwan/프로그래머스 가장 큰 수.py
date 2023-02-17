def solution(numbers):
    answer = ''
    #문자열로 변환
    arr= list(map(str,numbers))
    
		#1000까지의 수 이므로 비교를 위해 3번을곱해줌
    arr.sort(reverse=True, key=lambda x:x*3)
		#하나의 문자열로 합침
    result =''.join(arr)
		#001 같은 경우를 없애기 위해서 숫자로 변환 후 다시 문자로 변환
    answer = str(int(result))
    return answer