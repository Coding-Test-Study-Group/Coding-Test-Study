n,s = map(int, input().split())

arr = list(map(int,input().split()))

#투 포인터 사용
start,end = 0 ,0
sum = 0
len = 1e9

for start in range(n):
	#sum이 s보다 작거나 n이 end보다 크면, end+1(다음 원소를 더해줌)
  while sum < s and end<n:
    sum+=arr[end]
    end+=1
	#sum>=s이면 len값을 갱신하고 sum에서 맨 앞 원소를 빼줌
  if sum>=s:
    len = min(len,end-start)
  sum -=arr[start]

if len==1e9:
  print(0)
else:
  print(len)