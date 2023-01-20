import math

a,b =map(int,input().split())
# 제곱수 구하기
array = [i**2 for i in range(2,int(math.sqrt(b))+1)]

#a부터 b까지의 배열을 생성
check = [1 for _ in range(a,b+1)]


for i in array:
  num = a//i
  while num * i <= b:
    # num*i가 a와 b 범위안에 있을 경우
    if a <= num*i <= b:
      #0으로 설정
      check[num*i-a] = 0
    num+=1

print(sum(check))