import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

# 산술평균
print(round(sum(arr) / n))

# 중앙값
arr.sort()
print(arr[n // 2])

# 최빈값
cnt = Counter(arr).most_common() # 딕셔너리
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]:
    print(cnt[1][0])
else:
    print(cnt[0][0])

# 범위
print(abs(arr[-1] - arr[0]))