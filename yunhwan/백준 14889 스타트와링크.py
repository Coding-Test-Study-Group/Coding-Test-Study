N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

answer = int(1e9)


# 팀의 능력치 비교
def compare(team1, team2):
    sum_team1 = 0
    sum_team2 = 0

    for i in range(N // 2 - 1):
        for j in range(i + 1, N // 2):
            sum_team1 += arr[team1[i]][team1[j]] + arr[team1[j]][team1[i]]
            sum_team2 += arr[team2[i]][team2[j]] + arr[team2[j]][team2[i]]

    return abs(sum_team1 - sum_team2)


def select(team1, count, idx):
    global answer

    # link팀 뽑기
    if count == N // 2:
        team2 = []
        for i in range(N):
            if i not in team1:
                team2.append(i)

        diff = compare(team1, team2)
        # 기존값과 비교하여 더 작은 값이 answer
        answer = min(answer, diff)
        return

    # start팀 찾기
    for i in range(idx, N):
        if i not in team1:
            team1.append(i)
            select(team1, count + 1, i + 1)
            team1.remove(i)


select([], 0, 0)
print(answer)