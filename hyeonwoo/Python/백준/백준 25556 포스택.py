import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

four_stack = {1: [0], 2: [0], 3: [0], 4: [0]}

for i in range(n):
    cnt = 1

    while cnt < 5:
        if arr[i] > four_stack[cnt][-1]:
            four_stack[cnt].append(arr[i])
            break
        else:
            cnt += 1

    if cnt == 5:
        print("NO")
        break

if cnt < 5:
    print("YES")
