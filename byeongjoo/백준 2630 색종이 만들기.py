n = int(input())
board = []
white_paper = 0 # 하얀 종이
blue_paper = 0 # 파란 종이
for _ in range(n):
    board.append(list(map(int, input().split())))

def recur(x, y, n):
    global white_paper, blue_paper
    target = board[x][y] # 보드의 첫번째 인자를 타겟 설정
    flag = True # condition으로 가기 위해 flag 설정
    for i in range(x , x+n): # 보드를 순회하며 값 찾기
        for j in range(y, y+n):
            if target != board[i][j]: #타겟과 보드의 한 요소가 다르면
                flag = False # condition 못 감
                break
        if flag == False:
            break

    if flag == True: # condition 진입 가능
        if target == 1:
            blue_paper += 1
        elif target == 0:
            white_paper += 1
        return # 재귀 리턴

    offset = n//2 # offset 설정 - n을 2로 나누어줌
    for i in range(2):
        for j in range(2):
            recur(x+i*offset, y + j*offset , offset)



recur(0, 0, n)
print(white_paper)
print(blue_paper)