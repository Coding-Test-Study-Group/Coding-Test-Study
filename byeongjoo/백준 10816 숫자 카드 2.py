from bisect import bisect_left, bisect_right

n = int(input())
card = list(map(int, input().split()))
m = int(input())
targetList = list(map(int,input().split()))

card.sort()
for i in range(m):
    left = bisect_left(card, targetList[i])
    right = bisect_right(card, targetList[i])

    ans = right - left
    print(ans, end=" ")
