def solution(answers):
    cnt = [0] * 3
    way1 = [1, 2, 3, 4, 5]
    way2 = [2, 1, 2, 3, 2, 4, 2, 5]
    way3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    for idx, answer in enumerate(answers):
        if answer == way1[idx % len(way1)]:
            cnt[0] += 1
        if answer == way2[idx % len(way2)]:
            cnt[1] += 1
        if answer == way3[idx % len(way3)]:
            cnt[2] += 1
    result = []
    for idx, score in enumerate(cnt):
        if score == max(cnt):
            result.append(idx + 1)
    return result