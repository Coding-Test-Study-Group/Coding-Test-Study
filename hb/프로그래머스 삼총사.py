def solution(number):
    answer = 0
    count = 0
    if(len(number) < 3 or len(number) > 13):
        answer = False
        
    for i in range(len(number) - 2):
        if(number[i] < -1000 or number[i] > 1000):
            answer = False
        
        for j in range(i+1, len(number) - 1):
            for k in range(j+1, len(number)):
                if(number[i] + number[j] + number[k] == 0):
                    count += 1
    
    answer = count
    return answer