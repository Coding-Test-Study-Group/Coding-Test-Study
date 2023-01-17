n, m = map(int, input().split())

arr = [0 for _ in range(10)] # 출력할 값을 저장할 배열
start = 1 # 백트래킹할 때 값에 변화를 주기 위한 시작 변수

def nm(k): # k 는 자릿수를 의미함.
    global start # 전역변수 선언
    if k == m: # k의 자리수가 m과 같아진 경우 출력
        for i in range(m):
            print(arr[i], end=" ")
        print()
        return # 백트래킹 콜백

    if k != 0: # 현재 자릿수가 1이 아닌 경우
        start = arr[k-1] # 뒷 수는 앞 수의 영향을 받으므로 시작 변수를 바꿔야함.

    for i in range(start, n+1):
        arr[k] = i # 배열의 k번째 자리는 i
        nm(k+1) # k k+1 k+2 .. k+O(=m) 까지 자리 수 옮기기

nm(0)