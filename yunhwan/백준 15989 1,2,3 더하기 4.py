T = int(input())

nums = [int(input()) for i in range(T)]

#1의 합만 나타냄
dp = [1]*10001

#기존 값에서 2로 나타낼 수 있는 합을 추가
for i in range(2,10001):
  dp[i] += dp[i-2]
#기존 값에서 3으로 나타낼 수 있는 합을 추가
for i in range(3,10001):
  dp[i] += dp[i-3]

for i in range(T):
  print(dp[nums[i]])