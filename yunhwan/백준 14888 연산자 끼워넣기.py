n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

total_min = 1e9
total_max = -1e9

def dfs(i,cur):
  global  total_min,total_max

	#연산자의 개수만큼 재귀 최대값 최소값 구하기
  if i == n:
    total_max = max(total_max,cur)
    total_min = min(total_min,cur)

  else:
    #더하기
    if b[0] >0:
      b[0] -=1
      dfs(i+1, cur +a[i])
      b[0] +=1
    #빼기
    if b[1]>0:
      b[1]-=1
      dfs(i+1, cur-a[i])
      b[1]+=1
    #곱하기
    if b[2]>0:
      b[2]-=1
      dfs(i+1, cur*a[i])
      b[2]+=1
    #나누기
    if b[3]>0:
      b[3]-=1
      dfs(i+1, int(cur/a[i]))
      b[3]+=1

dfs(1,a[0])



print(total_max)
print(total_min)