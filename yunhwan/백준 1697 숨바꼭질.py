from collections import deque

n, k = map(int, input().split())
size = 100000
# 그래프 설정
g = [0] * (size + 1)


def bfs(start):
    # 큐생성
    q = deque()
    q.append(start)

    while (q):
        x = q.popleft()
        # k에 도달시 종료
        if x == k:
            print(g[x])
            break

        # 1초동안 이동할 수 있는 위치 탐색
        for i in (x + 1, x - 1, 2 * x):
            # 범위안에 있고, 갱신된적이 없으면
            if size >= i >= 0 and g[i] == 0:
                # 현재값에서 +1초
                g[i] = g[x] + 1
                # 큐에 i 추가
                q.append(i)


bfs(n)