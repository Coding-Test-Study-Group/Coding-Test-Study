import sys
sys.setrecursionlimit(10000)
cnt = 0 # 위치 값
def recur(n, r, c):
    global cnt
    if n == 0: # base condition
        return cnt

    line = 2**(n-1) # 사각형의 한 변의 길이의 반

    if r < line and c < line : # 행, 열이 특정 사각형의 변 길이의 반보다 모두 작을 때
        recur(n - 1, r, c)
        return cnt

    elif r < line and c >= line : # 행은 작고, 열은 크거나 같을 때
        recur(n - 1, r, c - line)
        cnt += line * line # 사각형 1개 추가
        return cnt

    elif r >= line and c < line: # 행은 크거나 같고, 열은 작을 때
        recur(n - 1, r - line, c)
        cnt += 2 * (line * line) # 사각형 2개 추가
        return cnt

    else: # 행, 열 모두 크거나 같을 때
        recur(n - 1, r - line, c - line)
        cnt += 3 * (line * line) # 사각형 3개 추가
        return cnt





n, r, c = map(int, input().split())
print(recur(n, r, c))