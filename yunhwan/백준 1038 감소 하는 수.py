N = int(input())

arr = []

cnt = 0
number = 0


# 수 찾기
def find_down(length, n):
    global arr

    # 숫자길이가 같을 때 배열에 추가
    if len(n) == length:
        arr.append(int(n))
        return True

    # 현재 숫자길이가 0일때
    if len(n) == 0:
        # 맨 앞의 수가 감소하는 수가 될 수 있도록 설정
        for i in range(length - 1, 10):
            find_down(length, n + str(i))

    else:
        # 감소하는 수가 될수 없는 경우
        if n[-1] == 0:
            return False
        # 0부터 앞의 수보다 작은 수까지만 가능
        for i in range(int(n[-1])):
            find_down(length, n + str(i))


# N==0일때 예외처리
if N == 0:
    print(0)


else:
    # 감소하는 수가 가능한것은 1~9876543210
    for i in range(1, 11):
        find_down(i, '')

    try:
        print(arr[N])
    # 오류시 -1출력
    except:
        print(-1)