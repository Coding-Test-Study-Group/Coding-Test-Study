n = int(input())
arr = []
count = 0
for _ in range(n):
    arr = input()
    stack = []
    for i in arr:
        if stack:
            if i == stack[-1]:
                stack.pop()
            else:
                stack.append(i)
        else:
            stack.append(i)

    if not stack:
        count +=1

print(count)