import sys

input = sys.stdin.readline


# 입력 받은 랜선의 길이로 케이블들을 잘랐을 때, 만들 수 있는 랜선의 개수를 반환하는 함수
def cut_cable(new_cable):
    result = 0

    for cable in cables:
        result += cable // new_cable

    return result


# 입력 받은 랜선의 길이로 n개 이상의 랜선을 가져갈 수 있는지 확인하는 함수
def check_cables(cable):
    if cut_cable(cable) >= n:
        return True

    if cut_cable(cable) < n:
        return False


# k: 이미 가지고 있는 랜선의 개수
# n: 필요한 랜선의 개수
k, n = map(int, input().split())

# 이미 가지고 있는 랜선들의 길이
cables = [int(input()) for _ in range(k)]

# n개를 무조건 만들 수 있는 랜선의 최소 길이
start = 1

# 랜선을 무조건 만들 수 없는 랜선의 최소 길이
end = max(cables) + 1

# start와 end의 범위를 좁혀가면서
# mid(랜선의 길이) 값으로 랜선을 n개 이상 가져갈 수 있는지 확인
while start + 1 < end:
    mid = (start + end) // 2

    if check_cables(mid):
        start = mid
    else:
        end = mid

print(start)
