def solution(sizes):
    answer = 0
    garo = [-1]
    sero = [-1]
    if len(sizes) < 1 and len(sizes) > 10000:
        answer = False
        
    for i in range(len(sizes)):
        sizes[i].sort()
        if sizes[i][0] < 1 and sizes[i][0] > 1000 and sizes[i][1] < 1 and sizes[i][1] > 1000:
            answer = False
    
    for item in sizes:
        if garo[0] < item[0]:
            garo.pop()
            garo.append(item[0])
        if sero[0] < item[1]:
            sero.pop()
            sero.append(item[1])
            
    answer = garo[0] * sero[0]
    return answer