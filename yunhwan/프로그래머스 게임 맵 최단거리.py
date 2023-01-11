from collections import deque


def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    v = [[0] * m for _ in range(n)]

    move = [[-1, 0], [1, 0], [0, 1], [0, -1]]

    def bfs():
        q = deque()
        q.append([0, 0, 1])

        while q:
            x, y, depth = q.popleft()

            for i in range(4):
                dx = x + move[i][0]
                dy = y + move[i][1]

                if n > dx >= 0 and m > dy >= 0:
                    if maps[dx][dy] != 0 and v[dx][dy] == 0:
                        v[dx][dy] = 1
                        maps[dx][dy] = maps[x][y] + 1
                        q.append([dx, dy, depth + 1])

        return maps[n - 1][m - 1]

    answer = bfs()

    if answer == 1:
        answer = -1

    return answer