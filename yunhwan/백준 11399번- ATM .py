import sys
input = sys.stdin.readline

n= int(input())

p = list(map(int,input().split()))
w = [0]*n
total = 0

#앞에서 인출시간이 짧을 수록 인출 시간의 합이 최소가 됌
#오름차순으로 정렬
p_sorted = sorted(p)

#w첫번째 원소를 정렬된 p의 첫번째 원소로 설정
w[0] = p_sorted[0]
total += w[0]
for i in range(1,n):
	#w[i]는 i-1번째까지 인출 시간 + i번째의 인출시간
  w[i] = w[i-1] + p_sorted[i]
  total +=w[i]

print(total)