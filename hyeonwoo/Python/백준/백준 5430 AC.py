import sys

input = sys.stdin.readline

t = int(input())  # 테스트 케이스
result = []

# 테스트 케이스 t만큼 반복
for i in range(t):
    p = list(map(str, input().rstrip()))  # 수행할 함수 배열
    n = int(input())  # 배열 크기
    string = str(input().rstrip()) # 배열

    # 입력 받은 배열에서 대괄호 삭제
    substring = string[1:-1]

    # R이 짝수 개수 이면, R이 없는 것과 같음
    # R이 홀수 개수 이면, R 한 번 수행한 것과 같음
    r_cnt = 0
    if p.count("R") % 2 == 0:
        r_cnt = 0
    else:
        r_cnt = 1

    # 배열이 비어 있지 않은 경우 ,로 구분 하여 새로운 배열에 저장
    if n > 0:
        arr = list(map(int, substring.split(",")))
    else:
        arr = []

    err_chk = 0  # 에러 체크용 변수

    # R 체크용 변수
    # 이 변수에 R이 나오면 -1을 곱하여
    # 양수, 음수 토글
    # 양수면, D는 첫 번재 수 삭제
    # 음수면, D는 마지막 수 삭제
    r_chk = 1
    for j in range(len(p)):
        # 배열이 비어 있고, D 연산일 때,
        if not arr and p[j] == "D":
            err_chk += 1
            break

        # 배열이 비어 있지 않을 때
        if arr:
            # r_chk 토글
            if p[j] == "R":
                r_chk *= -1

            # D 연산이고, r_chk가 양수면 첫 번째 삭제
            if p[j] == "D" and r_chk > 0:
                del arr[0]

            # D 연산이고, r_chk가 음수면 마지막 삭제
            if p[j] == "D" and r_chk < 0:
                del arr[-1]

    # 에러 체크
    if err_chk > 0:
        result.append("error")
    else:
        # r_cnt 값으로 R이 홀수 개수 만큼 있으면 R 연산 수행
        if r_cnt == 1:
            arr.reverse()

        result.append(arr)

# 출력 결과 보정
for i in result:
    string = ""

    # 에러가 아닌 경우 (배열인 경우)
    # 새로운 배열에 문자열로 저장
    # 앞, 뒤에 대괄호를 붙이고
    # ,를 구분자로 추가한다.
    if type(i) == list:
        new_i = list(map(str, i))
        string += "["
        string += ','.join(new_i)
        string += "]"
        print(string)
    else:
        # 에러는 그대로 출력
        print(i)
