def solution(brown, yellow):
    for i in range(1, int(pow(yellow, 0.5)) + 1):
        if yellow % i == 0:
            w = yellow // i
            h = i
            if brown == ((w + 2) * (h + 2) - yellow):
                return [w + 2, h + 2]