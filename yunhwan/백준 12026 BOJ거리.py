n = int(input())

arr = str(input())

# dp 생성
dp = [1e9] * (n)
dp[0] = 0

B = []
O = []
J = []
idx = 0

# B,O,J 각각 해당하는 주소 입력
for i in range(n):
    if arr[i] == 'B':
        B.append(i)
    elif arr[i] == 'O':
        O.append(i)
    elif arr[i] == 'J':
        J.append(i)

for i in range(n):

    if arr[i] == 'B':
        # i번째 이후에 올 O의 dp값 갱신
        for j in O:
            if j > i:
                # 현재 값과 (j-i)**2 중 작은 값으로 갱신
                dp[j] = min(dp[j], dp[i] + (j - i) ** 2)

    elif arr[i] == 'O':
        # i번째 이후에 올 J의 dp값 갱신
        for j in J:
            if j > i:
                dp[j] = min(dp[j], dp[i] + (j - i) ** 2)

    elif arr[i] == 'J':
        # i번째 이후에 올 B의 dp값 갱신
        for j in B:
            if j > i:
                dp[j] = min(dp[j], dp[i] + (j - i) ** 2)

            # 마지막 값이 갱신되지 않으면 불가능
if dp[-1] == 1e9:
    print(-1)
else:
    print(dp[-1])