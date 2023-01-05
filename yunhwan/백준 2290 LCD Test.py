s, n = map(int, input().split())

#각 숫자는 모두 s+2의 가로와 2s+3의 세로로 이루어 짐
arr = str(n)
l = len(str(n))

# 그래프 크기
w = l * (s + 2) + (l-1)
h = (2 * s + 3)

g = [[0] * w for _ in range(h)]

#'-' 선 긋기
# 3가지 중 선택
def lineRow(x, y, option):
    if option == 1:
        for i in range(y + 1, y + s + 1):
            g[x][i] = 1

    elif option == 2:
        for i in range(y + 1, y + s + 1):
            g[x + s + 1][i] = 1

    elif option == 3:
        for i in range(y + 1, y + s + 1):
            g[x + 2 * s + 2][i] = 1

#'|' 선 긋기
# 4가지 중 선택
def lineCol(x, y, option):
    global g
    if option == 1:
        for i in range(x + 1, x + s + 1):
            g[i][y] = 2

    elif option == 2:
        for i in range(x + 1, x + s + 1):
            g[i][y + s + 1] = 2

    elif option == 3:
        for i in range(x + s + 2, x + 2 * s + 2):
            g[i][y] = 2

    elif option == 4:
        for i in range(x + s + 2, x + 2 * s + 2):
            g[i][y + s + 1] = 2

# 번호에 맞게 줄 그어주기
for i in range(l):
    if arr[i] == '0':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '1':
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '2':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 2)
        lineRow(0, i * (s + 2)+i, 3)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 3)
    elif arr[i] == '3':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 2)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '4':
        lineRow(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '5':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 2)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '6':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 2)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '7':
        lineRow(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '8':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 2)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 4)
    elif arr[i] == '9':
        lineRow(0, i * (s + 2)+i, 1)
        lineRow(0, i * (s + 2)+i, 2)
        lineRow(0, i * (s + 2)+i, 3)
        lineCol(0, i * (s + 2)+i, 1)
        lineCol(0, i * (s + 2)+i, 2)
        lineCol(0, i * (s + 2)+i, 4)

#저장된 그래프를 읽고
#알맞은 출력
for i in range(h):
  for j in range(w):
        #print(g[i][j], end='')
    if g[i][j]==0:
        print(' ',end='')
    elif g[i][j]==1:
        print('-',end='')
    elif g[i][j]==2:
        print('|',end='')
  print()
