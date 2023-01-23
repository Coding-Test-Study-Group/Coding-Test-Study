#from operator import itemgetter

n = int(input())

arr = [[] for i in range(n+1)]

arr[0].append(0)
arr[0].append(0)

for i in range(1,n+1):
  s,e = map(int,input().split())
  arr[i].append(s)
  arr[i].append(e)

# 끝나는 시간 1순위, 시작하는 시간 2순위 기준으로 정렬
#arr.sort(key=itemgetter(1,0))
arr.sort(key=lambda x : (x[1], x[0]))
dp = [0]*(n+1)
prev = 0


for i in range(1,n+1):
  # 현재 시작 시간이 이전 끝나는 시간보다 같거나 커야함
  if arr[i][0] >= arr[prev][1]:
    #dp값을 이전 값에서 +1 크거나 기존값이랑 비교하여 큰값을 새로운 값으로 설정
    dp[i] = max(dp[i],dp[prev]+1)
    prev = i


print(max(dp))