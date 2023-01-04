n = int(input())

a = list(map(int, input().split()))

scv = [0] * 3

for i in range(n):
    scv[i] = a[i]

result = 1e9


def dfs(x, cnt):
    global result
    # 체력순으로 정렬
    x.sort()
    if x[0] <= 0 and x[1] <= 0 and x[2] <= 0:
        result = min(cnt, result)
        return True

    else:
        # 상황에 따라서 2번째 3번째 공격해야하는 scv고려
        dfs([x[0] - 1, x[1] - 3, x[2] - 9], cnt + 1)
        dfs([x[0] - 3, x[1] - 1, x[2] - 9], cnt + 1)


dfs(scv, 0)

print(result)