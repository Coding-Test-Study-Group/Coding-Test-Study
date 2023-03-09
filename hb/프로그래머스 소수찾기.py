# https://school.programmers.co.kr/learn/courses/30/lessons/12921
def solution1(n):
    answer = 0
    # 1은 어차피 소수가 아니니까 시작 부터 제외하고 2 부터 n 까지를 요소로 갖는 set을 생성
    # 해당 set으로 한 이유는 set[] - set[] 을 하면 일반적으로 아는 차집합이 실행되기 때문
    temp = set(i for i in range(2, n + 1))

    # i 를 2 부터 n+1 까지 돌면서 i의 자기 자신(1 * i) 를 제외한 숫자를 제거( set 을 생성해서 차집합 )
    # 1 * i 가 다른 i 의 배수가 아니라서 계속 남아있는 경우 그 수는 소수이기 때문이다.
    for i in range(2, n + 1):
        temp -= set(i for i in range(2 * i, n + 1, i)) # 2 * i 부터 n까지 i 씩 늘리면 i 자신을 제외한 배수들에 해당되는 것

    answer = len(temp)
    return answer

def solution2(n):
        answer = 0
        temp = set(i for i in range(2, n + 1))

        # solution1 과 비슷하나 불필요한 반복을 제거하기 위해서
        # n 의 약수는 제곱근을 대칭으로 몫과 나머지가 반비례하기 때문에 제곱근을 기준으로 제일 작은 약수 부터 제곱근까지 확인하면 모든 약수의 결과를 알 수 있다는
        # 개념을 추가.
        # 즉 n의 제곱근 보다 작거나 같은 수 로 나눠지는 숫자까지만 반복해서 시행해서 각 i 의 모든 자신을 제외한 모든 배수를 삭제할 수 있다.
        for i in range(2, int(n**(1/2)) + 1):
            # if i in temp : 를 추가하면 시간을 더 단축할 수 있다.
            temp -= set(i for i in range(2 * i, n + 1, i)) # 2 * i 부터 n까지 i 씩 늘리면 i 자신을 제외한 배수들에 해당되는 것

        answer = len(temp)
        return answer   