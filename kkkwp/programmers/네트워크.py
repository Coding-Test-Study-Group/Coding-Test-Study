def dfs(idx, n, visited, computers):
    visited[idx] = True
    for cur in range(n):
        # 자기 자신을 제외하고, 연결되어 있는 컴퓨터 확인
        if cur != idx and computers[idx][cur] == True:
            # 방문하지 않은 곳이면 진행
            if visited[cur] == False:
                dfs(cur, n, visited, computers)

def solution(n, computers):
    answer = 0
    visited = [False for _ in range(n)]
    for i in range(n):
        if not visited[i]:
            dfs(i, n, visited, computers)
            answer += 1
    return answer