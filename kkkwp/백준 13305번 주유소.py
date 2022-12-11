n = int(input())
path = list(map(int, input().split()))
cost = list(map(int, input().split()))

answer = 0
minVal = cost[0]
for i in range(n - 1):
    if cost[i] < minVal:
        minVal = cost[i]
    answer += minVal * path[i]

print(answer)