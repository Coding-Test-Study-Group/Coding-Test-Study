# 2를 곱한다 *=2
# 1을 수의 가장 오른쪽에 추가 *=10 +=1

a, b = map(int, input().split())
result = 1e9


# 백트래킹을 이용한 dfs
def dfs(num, cnt):
    global result

    if num < a:
        return 0

    if num == a:
        result = min(cnt, result)

    # 맨뒤자리가 1이면 10을 나눈 값을 dfs
    if num % 10 == 1:
        dfs(num // 10, cnt + 1)
    # 짝수일 경우 2를 나눈 값을 dfs
    if num % 2 == 0:
        dfs(num // 2, cnt + 1)


# b에서부터 a까지 탐색하는 dfs
dfs(b, 1)

if result == 1e9:
    print(-1)
else:
    print(result)
