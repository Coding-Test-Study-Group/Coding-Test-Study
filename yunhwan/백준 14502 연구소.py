from collections import deque
from itertools import combinations

n, m = map(int, input().split())

g = [list(map(int, input().split())) for _ in range(n)]
ans = 0

#벽을 3개 사용하여 최대한의 0(안전영역)을 만드는 것이 중요
# 안전영역은 전부 이어있음

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

virus = []
safety = []
wall = []


def bfs(g, x, y):
    q = deque()
    q.append((x, y))

    while (q):
        cx, cy = q.popleft()

        for i in range(4):
            nx = dx[i] + cx
            ny = dy[i] + cy
            if 0 <= nx < n and 0 <= ny < m:
                if g[nx][ny] == 0:
                    q.append((nx, ny))
                    g[nx][ny] = 2


def cntSafety(graph):
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                cnt += 1
    return cnt


for i in range(n):
    for j in range(m):
        if g[i][j] == 0:
            safety.append([i, j])
        if g[i][j] == 1:
            wall.append([i, j])
        if g[i][j] == 2:
            virus.append([i, j])

#벽 3개의 조합 리스트 생성
newWall = list(combinations(safety, 3))

for i in newWall:
    #그래프 복사
    newgraph = [arr[:] for arr in g]
    #벽 추가
    for j in i:
        newgraph[j[0]][j[1]] = 1
    #바이러스 퍼뜨리기
    for k in virus:
        bfs(newgraph, k[0], k[1])
    #안전영역이 가장 많은 경우가 정답
    ans = max(cntSafety(newgraph), ans)

print(ans)