h, w = map(int, input().split())

g = list(map(int, input().split()))

result = 0

# 양 끝에 벽이 존재해야함
# 존재한 다면 결과값에 더해줌

for i in range(h):
    row = 0
    flag = 0
    for j in range(w):
        # 맨 처음
        if j == 0:
            # 빗물 세기 허용
            if g[j] > i:
                flag = 1

        # 맨 마지막
        elif j == w - 1:
            # 빗물 세기 허용
            if g[j] > i:
                result += row
        # 중간
        else:
            # 모은 빗물 더해 준 뒤 초기화
            if g[j] > i:
                result += row
                row = 0
                flag = 1
            # 빗물 더해주기
            else:
                if flag == 1:
                    row += 1

print(result)