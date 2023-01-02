import math

t = int(input())

arr = [list(map(int,input().split())) for _ in range(t)]

result = []

for i in range(t):
  result.append( math.factorial(arr[i][1]) // (math.factorial(arr[i][1]-arr[i][0]) * math.factorial(arr[i][0])))

for i in result:
  print(i)