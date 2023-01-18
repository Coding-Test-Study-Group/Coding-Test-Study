n, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort() ## 데이터를 내림차순으로 정렬
arr = [0 for _ in range(10)]
isused= [False for _ in range(10)] # 수열 중 i 요소가 사용되는지 체크하는 불린 리스트

def nm(k):
    if m == k:
        for i in range(m):
            print(data[arr[i]], end=" ") # 데이터의 arr[i]의 요소를 출력
        print()
        return

    for i in range(n): # data[arr[i]] 이기에 0부터 시작해야함. 기존처럼 1부터 시작할시 out of range 나옴.
        if not isused[i]: # 만약 i 수를 사용하지 않았다면
            isused[i] = True # i는 사용됬다고 True 를 대입
            arr[k] = i # 자릿수 k 는 i를 대입
            nm(k+1) # 자릿수 증가시키기
            isused[i] = False # i 수를 백트래킹을 진행하며 다 사용했을 경우 사용 가능하다고 False 대입

nm(0)