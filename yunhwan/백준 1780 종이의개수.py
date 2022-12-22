n = int(input())

g = [list(map(int, input().split())) for _ in range(n)]

ans = [0, 0, 0]


# 종이가 같은 수인지 체크
def check(size, x, y):
    for i in range(size):
        for j in range(size):
            # 종이가 같은 수가 아닌경우
            if g[x][y] != g[x + i][y + j]:
                return -1

    return g[x][y] + 1


# 종이 탐색
def dfs(size, x, y):
    global ans

    result = check(size, x, y)

    # 종이가 같은 수로 구성된다면
    if result != -1:
        # 해당되는 수 +1
        ans[result] += 1
        return

    for i in range(3):
        for j in range(3):
            next_size = size // 3
            # print(next_size)
            # 9개의 종이 dfs 실행
            dfs(next_size, x + i * next_size, y + j * next_size)


dfs(n, 0, 0)

for i in ans:
    print(i)
