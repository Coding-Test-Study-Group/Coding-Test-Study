from itertools import combinations, permutations
import math


def isPrime(x):
    if x<=1:
        return False
    
    for i in range(2, int(math.sqrt(x))+1):
        if x%i==0:
            return False
    
    return True

def solution(numbers):
    answer = 0

    arr = list(numbers)
    paper = []
    
    #1. numbers 조합 구하기
    for i in range(len(arr)):
        paper += list(permutations(arr,i+1))
    
    #2. 숫자로 변환
    for i in range(len(paper)):
        paper[i] =  int(''.join(paper[i]))
        
    #3. 중복 제거
    paper = list(set(paper))

    #4. 소수 판별
    for i in paper:
        if isPrime(i):
            answer+=1
    
    
    return answer