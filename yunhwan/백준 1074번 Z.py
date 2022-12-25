N, r, c = map(int, input().split())
ans = 0


#dfs를 통해 순서 찾기
def dfs(size, s, x, y):
    global ans

    #박스 크기
    idx = (size**2) // 4

    #찾는 박스(4칸일 때)
    if idx == 1:
        if r % 2 == 0:
            if (c % 2 == 0):
                ans = s
            else:
                ans = s + 1
        else:
            if (c % 2 == 0):
                ans = s + 2
            else:
                ans = s + 3
        return
    #첫번째 박스
    if x > r and y > c:
        dfs(size // 2, s, x - size // 4, y - size // 4)

    #두번째 박스
    elif x > r and y <= c:
        dfs(size // 2, s + idx, x - size // 4, y + size // 4)

    #세번째 박스
    elif x <= r and y > c:
        dfs(size // 2, s + idx * 2, x + size // 4, y - size // 4)

    #네번째 박스
    else:
        dfs(size // 2, s + idx * 3, x + size // 4, y + size // 4)


dfs(2**N, 0, 2**(N - 1), 2**(N - 1))

print(ans)