# n % x = 1 이 되게 하는 x 중 가장 작은 x를 구하기 위해서 x는 n-1로 취급하여 x의 약수 중 1이 아닌 가장 작은 약수를 구한다.
# 1 부터 x의 중간수 까지 1부터 x의 중간수로 나누어서 나머지가 0이 되게 하는 i의 값을 리스트에 추가
# i 제곱의 값이 x 가 아닌 경우를 판별(중복값 방지) -> 짝이 되는 수가 i와 같은 경우
# 아닌경우에는 x 를 i로 나눈 몫을 추가 (i의 짝이 되는 수 추가)
# 이후 완성된 리스트에서 1제거하고 정렬 후 가장 작은 값 반환
def solution(n):
    answer = 0
    divisorsList = []
    
    x = n-1
    
    for i in range(1, int(x**(1/2))+1):
        if(x % i == 0):
            divisorsList.append(i)
            
            if((i ** 2) != x):
                divisorsList.append(x // i)

    divisorsList.remove(1)
    divisorsList.sort()
    answer = divisorsList[0]
    
    return answer

# x는 n+1 로 하여 n % (1 ~ n+1) = 1 이 되게 하는 가장 작은 수를 구하기
""" 
def solution(n):
    answer = min([x for x in range(1, n+1) if n % x == 1])
    return answer
    
"""