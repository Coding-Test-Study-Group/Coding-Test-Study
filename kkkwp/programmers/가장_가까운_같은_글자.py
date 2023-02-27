def solution(s):
    answer = []
    dic = {}
    for idx, alpha in enumerate(list(s)):
        if alpha not in dic:
            answer.append(-1)
            dic[alpha] = idx
        else:
            answer.append(idx - dic[alpha])
            dic[alpha] = idx
    return answer