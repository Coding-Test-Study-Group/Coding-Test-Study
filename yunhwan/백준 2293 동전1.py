n,k = map(int,input().split())

arr = [int(input()) for i in range(n)]
dp = [0]*(k+1)


#arr 맨 처음 수로 만들 수 있는 숫자들이 있다면 +1 해줌
for i in range(k+1):
  if i%arr[0]==0:
    dp[i]+=1


# arr의 남은 원소들 사용
for i in range(1,n):
  cur = arr[i]
  # 1부터 k까지 반복
  for j in range(1,k+1):
    # cur이 j이상일 때 (dp[j-cur]음수 방지)
    if j>=cur:
      #기존 dp[j]에 dp[j-cur]을 더해 줌
      dp[j] = dp[j] + dp[j-cur]


print(dp[k])