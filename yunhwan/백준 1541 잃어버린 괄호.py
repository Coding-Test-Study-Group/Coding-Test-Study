arr = str(input())

start=0
end = 0

num = []
bind = []


#숫자 저장
for i in range(len(arr)):
  if arr[i]=='+' or arr[i]=='-':
    end=i
    num.append(int(arr[start:end]))
    start=i

num.append(int(arr[start:]))

min_val =sum(num)
cur = 0
start= len(num)

for i in range(1,len(num)):

  #음수일 경우
  if num[i]<0:
    if start==len(num):
      start=i
    #양수로 변경
    cur=-num[i]

    #마지막 인덱스일 경우
    if i==len(num)-1:
      bind.append(-cur)
      break

    for j in range(i+1,len(num)):
      #음수인 경우
      if num[j]<0:
        #부호바꿔서 괄호 안에 추가
        bind.append(-cur)
        break
      else:
        cur+=num[j]
        #마지막 인덱스일 경우
        if j==len(num)-1:
          #부호바꿔서 괄호 안에 추가
          bind.append(-cur)
          break

#비교해서 작은값 설정
min_val=min(sum(num[0:start])+sum(bind),min_val)

print(min_val)