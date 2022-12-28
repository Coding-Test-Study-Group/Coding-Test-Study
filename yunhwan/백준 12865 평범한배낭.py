n, k = map(int, input().split())

arr = [[0, 0]]

for i in range(n):
    w, v = map(int, input().split())
    arr.append([w, v])

# 이차원 dp 생성
dp = [[0] * (k + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    w, v = arr[i]
    for j in range(1, k + 1):
        # 무게가 j보다 크다면
        if j < w:
            # 가방에 들어올 수 없으므로
            # 현재 가치는 가방에 들어오지 않을 때와 동일
            dp[i][j] = dp[i - 1][j]

        # 무게가 j이하 이면
        else:
            # 가방에 들어갈 수 있으므로
            # 가방에 들어가지 않을 때와 가방에 들어갈 때 중 큰 가치를 선택
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w] + v)

print(dp[n][k])