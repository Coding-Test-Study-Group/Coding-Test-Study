def solution(k, score):
    answer = []
    hall = []
    for s in score:
        hall.append(s)
        if len(hall) > k:
            hall.remove(min(hall))
        answer.append(min(hall))
    return answer