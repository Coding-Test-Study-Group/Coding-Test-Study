# 두 동전
import copy
from collections import deque
N, M = map(int, input().split())
arr = []
cost = deque()
for i in range(N):
    arr.append(list(input().strip()))
    for j in range(M):
        if arr[i][j] == 'o':
            cost.append((i, j))
            arr[i][j] = '.'

visited = set()
visited.add(''.join(map(str, cost)))

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def bfs():
    q = deque()
    q.append((0, cost))
    while q:
        cnt, now = q.popleft()
        if cnt >= 10:
            return -1
        for k in range(4):
            # now를 깊은 복사
            temp = copy.deepcopy(now)
            # 동전의 개수는 두개
            for _ in range(2):
                x, y = temp.popleft()
                nx = x+dx[k]
                ny = y+dy[k]
                #범위 안에 있는 경우
                if 0 <= nx < N and 0 <= ny < M:
                    #빈 칸일 경우 이동값
                    if arr[nx][ny] == '.':
                        temp.append((nx, ny))
                    #벽일 경우 기존값
                    elif arr[nx][ny] == '#':
                        temp.append((x, y))
            # 동전 개수가 1개이면 종료
            if len(temp) == 1:
                return cnt+1
            # 동전 개수가 0개이면 continue
            elif len(temp) == 0:
                continue
            # 동전 개수가 2개이면
            #방문 좌표를 visited추가 & q.append
            visit = ''.join(map(str, temp))
            if visit not in visited:
                visited.add(visit)
                q.append((cnt+1, temp))
    return -1


print(bfs())