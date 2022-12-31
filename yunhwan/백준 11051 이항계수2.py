n,k = map(int,input().split())

x,y =1,1

for i in range(n,n-k,-1):
  x *=i
  y *=(n-i+1)

result =x//y

print(result%10007)