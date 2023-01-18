def solution(survey, choices):
    answer = ''
    l = len(survey)
    mbti = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    result = [0] * 4
    idx = 0

    for i in range(l):
        mul = 1
        if survey[i][0] == 'R' or survey[i][0] == 'T':
            if survey[i][0] == 'T': mul *= -1
            idx = 0
        elif survey[i][0] == 'C' or survey[i][0] == 'F':
            if survey[i][0] == 'F': mul *= -1
            idx = 1
        elif survey[i][0] == 'J' or survey[i][0] == 'M':
            if survey[i][0] == 'M': mul *= -1
            idx = 2
        elif survey[i][0] == 'A' or survey[i][0] == 'N':
            if survey[i][0] == 'N': mul *= -1
            idx = 3

        choices[i] *= -1
        choices[i] += 4
        choices[i] *= mul

        result[idx] += choices[i]

    for i in range(4):
        if result[i] >= 0:
            answer += mbti[i * 2]
        else:
            answer += mbti[i * 2 + 1]

    return answer