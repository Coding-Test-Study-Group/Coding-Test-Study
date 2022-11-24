n = int(input())
arr = list(map(int, input().split()))
stack= []
ans = [-1] * n

for i in range(n):

    while stack and (stack[-1][0] < arr[i]):
        val, idx = stack.pop()
        ans[idx] = arr[i]
    stack.append((arr[i], i))

print(*ans)