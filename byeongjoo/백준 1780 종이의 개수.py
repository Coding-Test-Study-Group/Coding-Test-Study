import sys

sys.setrecursionlimit(10000) # 재귀 뚫어주기
input = sys.stdin.readline
n = int(input())
minus_sum = 0 # -1의 개수
zero_sum = 0 # 0의 개수
plus_sum = 0 # 1의 개수
board = []
for _ in range(n):
    board.append(list(input().split()))

def recur(x, y, n):

    global minus_sum, zero_sum, plus_sum
    target = board[x][y] #3^n * 3^n 종이의 좌측 상단을 타켓으로 잡기
    flag = True # 3^n * 3^n 종이를 하나로 취급할지 안할지에 대한 flag

    for i in range(x, x+n):
        for j in range(y, y+n):
            if board[i][j] != target: # 한 종이 내에서 이미 숫자가 다르다면
                flag = False
                break
        if not flag: # 2중 for문 탈출
            break

    if flag == True: # 3^n * 3^n 이 모두 같은 크기일 때 , 하나하나의 요소
        if int(target) == 1:
            plus_sum += 1
        elif int(target) == 0:
            zero_sum += 1
        elif int(target) == -1:
            minus_sum += 1
        return

    offset = n // 3 # offset 크기 분할하기
    for i in range(3):
        for j in range(3):
            recur(x+offset*i, y+offset*j, offset) # 재귀.
            """
                 (x,y)           (x,y+offset)            (x,y+2*offset)
            (x+offset, y)    (x+offset, y+offset)    (x+offset, y+2*offset)
            (x+2*offset, y) (x+2*offset, y+offset)   (x+2*offset, y+2*offset)
            """


recur(0, 0, n)
print(minus_sum)
print(zero_sum)
print(plus_sum)