def solution(s):
    stack = []
    for it in s:
        if it == "(":
            stack.append(it)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    return len(stack) == 0