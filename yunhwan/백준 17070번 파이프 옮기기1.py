n = int(input())
g = []

for i in range(n):
    row = list(map(int, input().split()))
    g.append(row)

dp = []

for i in range(n):
    row = [[0] * 3 for j in range(n)]
    dp.append(row)

# 가로, 대각선, 세로
move = [[0, 1], [1, 1], [1, 0]]
dp[0][1][0] = 1

for i in range(n):
    for j in range(n):
        # 3가지 방향 조회
        for k in range(3):
            dx = i + move[k][0]
            dy = j + move[k][1]

            # 범위 밖이거나 벽이면 continue
            if dx < 0 or dx >= n or dy < 0 or dy >= n or g[dx][dy] == 1:
                continue
            # 대각선 이동시 벽에 닿을 때
            if k == 1 and (g[dx - 1][dy] == 1 or g[dx][dy - 1] == 1):
                continue

            # 가로일 때
            if k == 0:
                if dp[i][j][0]:
                    dp[dx][dy][k] += dp[i][j][0]
                if dp[i][j][1]:
                    dp[dx][dy][k] += dp[i][j][1]

            # 대각선일 때
            if k == 1:
                if dp[i][j][0]:
                    dp[dx][dy][k] += dp[i][j][0]
                if dp[i][j][1]:
                    dp[dx][dy][k] += dp[i][j][1]
                if dp[i][j][2]:
                    dp[dx][dy][k] += dp[i][j][2]

            # 세로일 때
            if k == 2:
                if dp[i][j][1]:
                    dp[dx][dy][k] += dp[i][j][1]
                if dp[i][j][2]:
                    dp[dx][dy][k] += dp[i][j][2]

print(sum(dp[n - 1][n - 1]))