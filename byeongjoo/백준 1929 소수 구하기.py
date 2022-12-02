import math

m , n = map(int,input().split())

board = [True for _ in range(n+1)]

for i in range(2, int(math.sqrt(n))+1):
    j = 2
    while i*j <= n:
        board[i*j] = False
        j += 1

for i in range(m, n+1):
    if i == 1:
        continue
    if board[i]:
        print(i)