import sys

n, k = map(int, input().split())

arr = []
# anta tica에 들어가는 알파벳
cur = ['a', 'n', 't', 'i', 'c']
# cur을 제외한 알파벳
alphabet = [
    'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's',
    'u', 'v', 'w', 'x', 'y', 'z'
]

result = 0

# 입력 받기
for i in range(n):
    s = str(input().strip())
    arr.append(s)

if k < 5:
    print(0)
    sys.exit()


# cur에 있는 알파벳만 사용하는 단어 찾기
def check():
    result = 0
    for i in range(len(arr)):
        visited = True
        # anta ? tica이므로 인덱스범위 4 ~ len(arr[i])-4
        for j in range(4, len(arr[i]) - 4):
            if arr[i][j] not in cur:
                visited = False
                break
            # 해당 배열로 조합가능하다면
        if visited == True:
            result += 1
    return result


# dfs 탐색을 통해 가르칠 수 있는 최대 단어수 찾기
def dfs(cnt, start):
    global result
    # k와 cnt가 같을 경우
    if cnt == k:
        # 최대값을 reuslt로 갱신
        result = max(result, check())
        return
    for i in range(start, len(alphabet)):
        cur.append(alphabet[i])
        dfs(cnt + 1, i + 1)
        cur.pop()


dfs(5, 0)
print(result)