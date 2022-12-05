from collections import deque
import sys

input = sys.stdin.readline


def bfs(x, y):
    # 큐 선언
    queue = deque()

    # (x, y)를 이미 방문한 곳으로 처리
    visited[x][y] = 1

    # (x, y)를 큐에 추가
    queue.append((x, y))

    # 큐가 비어있지 않다면
    while queue:
        # 큐에서 (x, y)를 뺀다
        x, y = queue.popleft()
        dx_dy = [(0, -1), (0, 1), (-1, 0), (1, 0)]

        # (x, y)에 연결된 각각의 정점에 대해서
        for dx, dy in dx_dy:
            nx = x + dx
            ny = y + dy

            # 인덱스 범위 안에 있다면
            if -1 < nx < n and -1 < ny < n:
                # 정점(nx, ny)에 아직 방문하지 않았다면
                if graph[nx][ny] == graph[x][y] and not visited[nx][ny]:
                    # (nx, ny)를 방문한 곳으로 추가
                    visited[nx][ny] = 1

                    # 큐에 (nx, ny)를 추가
                    queue.append((nx, ny))


n = int(input())
graph = [list(map(str, input().rstrip())) for _ in range(n)]
visited = [[0 for _ in range(n)] for _ in range(n)]

# 적록색약이 아닌 경우
result_1 = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            result_1 += 1

# 적록색약인 경우를 구하기 위해 방문 그래프 초기화
visited = [[0 for _ in range(n)] for _ in range(n)]

# 적록색약인 경우 (R을 G로 바꾼다)
result_2 = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == "R":
            graph[i][j] = "G"

for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j)
            result_2 += 1

print(result_1, result_2)
