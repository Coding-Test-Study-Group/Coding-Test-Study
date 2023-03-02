# try hello world -> TrY HeLlO WoRlD

def solution(s):
    answer = ''
    temp = list(s.split(' '))
    print(temp)
    for item in temp:
        changeWord  = ''
        for i in range(len(item)):
            if i % 2 == 0:
                changeWord += item[i].upper()
            else:
                changeWord += item[i].lower()
        
        
        answer += changeWord 
        answer += " "
    answer = answer[:len(answer)-1]
    return answer 