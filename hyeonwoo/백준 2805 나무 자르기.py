import sys


# 절단기의 높이로 나무를 가져갈 수 있는지 확인
def check_tree(cutter_height):
    sum = 0
    for i in trees:
        target = i - cutter_height
        if target > 0:
            sum += target

    if sum >= m:
        return True
    else:
        return False


input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

# 나무를 무조건 가져갈 수 있는 높이
start = 0

# 나무를 무조건 가져갈 수 없는 높이
end = max(trees)

# start + 1과 end가 같아질 때까지 반복
# start와 end의 범위를 좁혀가며
# mid(절단기의 높이) 값으로 나무를 가져갈 수 있는지 없는지 확인
while start + 1 < end:
    mid = (start + end) // 2

    if check_tree(mid):
        start = mid
    else:
        end = mid

print(start)

"""
# 시간 초과 코드

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

cutter_height = max(trees)
sum = 0
while sum != m:
    for i in trees:
        target = i - cutter_height
        if target > 0:
            sum += target

    if sum != m:
        total = 0
        cutter_height -= 1

print(cutter_height)
"""
