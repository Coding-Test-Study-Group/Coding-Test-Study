from collections import deque

n, m = map(int, input().split())

g = [list(map(int, input().split())) for _ in range(n)]

# 8방향
way = [[-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]]

ans = 0
# 큐 생성
q = deque()


def bfs():
    while q:

        x, y = q.popleft()
        # 8방향으로 탐색
        for i in range(len(way)):
            nx = x + way[i][0]
            ny = y + way[i][1]

            # 이동할 수 있는 경우
            if n > nx >= 0 and m > ny >= 0:
                # 방문한 적 없는 경우
                if g[nx][ny] == 0:
                    # 큐에 추가
                    q.append((nx, ny))
                    # 기존거리에서 1더해주기
                    g[nx][ny] = g[x][y] + 1


for i in range(n):
    for j in range(m):
        # 상어가 있는 곳을 큐에 추가
        if g[i][j] == 1:
            q.append([i, j])

bfs()

# 그래프에서 가장 큰 값 - 1
print(max(map(max, g)) - 1)