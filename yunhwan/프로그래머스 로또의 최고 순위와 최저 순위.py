def solution(lottos, win_nums):
    answer = []
    plus = 0
    cnt = 0
    dic = {}

    # 맞춘 개수에 따른 순위 저장
    for i in range(7):
        if i <= 1:
            dic[i] = 6
        else:
            dic[i] = 7 - i

    # 일치하는 수는 cnt, 0인 수는 plus 설정
    for i in range(6):
        if lottos[i] in win_nums:
            cnt += 1
        if lottos[i] == 0:
            plus += 1

    # 최대로 맞쳤을 때 순위, 최소로 맞쳤을 때 순위
    answer = [dic[cnt + plus], dic[cnt]]

    return answer