def solution(id_list, report, k):
    l = len(id_list)
    answer = []
    # report 중복제거
    report_set = set(report)
    dic1 = {}
    dic2 = {}

    for i in id_list:
        dic1[i] = 0
        dic2[i] = 0

    # 신고받은 횟수 구하기
    for claim in report_set:
        a, b = claim.split()
        # 자기 자신이 신고 못함
        if a != b:
            dic1[b] += 1

        # 자신이 정지시킨 사람 수 구하기
    for claim in report_set:
        a, b = claim.split()
        if dic1[b] >= k:
            dic2[a] += 1

    for i in id_list:
        answer.append(dic2[i])

    return answer