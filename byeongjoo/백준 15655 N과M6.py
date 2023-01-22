n, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort() # 데이터 내림차순 정렬
arr = [0 for _ in range(10)] # 0, 1, 2 ... 처럼 순서를 저장할 리스트
start = 0 # 자릿수마다 시작값을 바꿔줄 변수. 초기값은 0
def nm(k):
    global start # 전역변수 설정
    if m == k : # 백트래킹으로 찾은 depth가 조건에 만족하는 수열까지 찾아갔다면
        for i in range(m):
            print(data[arr[i]], end=" ") # 데이터의 arr[i]의 요소 꺼내기
        print()
        return # 콜백

    if k != 0 : # k가 시작(0) 요소가 아니라면?
        start = arr[k-1] + 1 # 스타트 포인트는 arr의 이전 값의 1을 더한 값.
    for i in range(start, n): # start 부터 n-1까지 반복
        arr[k] = i # 순서리스트의 k 요소는 start부터 시작한 값을 지정
        nm(k+1) # 백트래킹


nm(0)