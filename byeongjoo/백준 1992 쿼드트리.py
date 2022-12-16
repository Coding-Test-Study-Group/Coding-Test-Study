n = int(input())

board = []
ans = []
for _ in range(n):
    board.append(list(input()))

def recur(x, y, n):
    global ans # 전역변수 만들기
    target = board[x][y] # 타겟 만들기
    for i in range(x, x+n):
        for j in range(y, y+n):
            if target != board[i][j]: # 만약 타겟과 보드의 요소가 다르다면 보드 4분할
                offset = n // 2 # 분할정복을 위해 offset을 2로 나눔
                ans.append("(") # 문제의 목적에 맞게 작은 크기로 잘라 괄호 안에 만들어주기
                recur(x, y, offset) # (x, y)
                recur(x, y+offset, offset) # (x, y+offset)
                recur(x+offset, y, offset) # (x+offset , y)
                recur(x+offset, y+offset, offset) # (x+offset, y+offset)
                ans.append(")")
                return

    ans.append(target) # n*n 크기라면 ans 리스트에 추가

recur(0,0,n)

answer = "".join(map(str,ans)) # 문자열로 만들어주기

print(answer)