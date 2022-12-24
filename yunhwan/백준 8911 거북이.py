n = int(input())
arr = []

# 문장 입력
for i in range(n):
  arr.append(input())

# 문장 개수만큼 반복
for i in range(len(arr)):
  # 현재 위치, x,y 저장 배열, 방향 초기화
  cur=[0,0]
  x,y =[0],[0]
  move = [0,1]
  # 문장길이만큼 반복
  for j in range(len(arr[i])):
    #이동 거리 초기화
    distance = 0

    # 90도 이동
    if arr[i][j]=='R':
        move[0],move[1] = move[1],-move[0]
    #-90도 이동
    elif arr[i][j]=='L':
        move[0],move[1] = -move[1],move[0]
    # 앞뒤로 움직일 때
    else:
      # 이동거리 +1
      if arr[i][j] =='F':
        distance+=1
      # 이동거리  -1
      elif arr[i][j] =='B':
        distance-=1
      # 현재위치 갱신
      cur[0]+=(move[0]*distance)
      cur[1]+=(move[1]*distance)
      # x,y 배열에 추가
      x.append(cur[0])
      y.append(cur[1])
  #x가 지나간 길이  * y가 지나간 길이
  print(abs(max(x)-min(x)) * abs(max(y)-min(y)))