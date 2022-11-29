def solution(s):
    stack = []
    for ch in s:
        if len(stack) == 0:
            stack.append(ch)
        elif ch == stack[-1]:
            stack.pop()
        else:
            stack.append(ch)
    return 1 if len(stack) == 0 else 0