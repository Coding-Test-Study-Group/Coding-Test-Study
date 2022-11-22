"""
AC
R은 뒤집기
D는 버리기
R은 배열에 있는 수의 순서를 뒤집음
D는 첫 번째 수를 버림.
배열이 비어있는데 D를 사용하면 에러 발생함.
"""

from collections import deque

T = int(input())

for _ in range(T):
    p = input()
    n = int(input())
    dq = deque(input()[1:-1].split(','))
    R = 0
    flag = 1

    if n == 0:
        dq = deque()

    for i in p:
        if i == "R":
            R = 1 - R
            # R이 짝수면 뒤집기 안해도 됨.
            # R이 홀수면 뒤집기.
        if i == "D":
            if len(dq) == 0:
                print('error')
                flag = 0
                break
            else:
                if R == 0:
                    dq.popleft()
                else:
                    dq.pop()
    else:
        if flag == 1:
            # if len(dq) == 0:
            #     print('error')
            #     continue
            if R == 1:
                dq.reverse()

            print("["+ ",".join(dq)+ "]")

