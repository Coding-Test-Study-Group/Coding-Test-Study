from collections import deque
import sys

input = sys.stdin.readline

result = []
while True:
    string = str(input().rstrip())

    # 반복문 종료 조건
    if string == ".":
        break

    # 입력 받은 문자열 중 소괄호와 대괄호만 target 배열에 추가
    target = []
    for i in string:
        if i == "[" or i == "]" or i == "(" or i == ")":
            target.append(i)

    # 괄호가 하나도 없는 경우도 균형잡힌 문자열로 간주
    if not target:
        result.append("yes")
        continue

    stack = deque([])
    for i in target:
        if i == "[" or i == "(":
            stack.append(i)

        if i == "]":
            if stack and stack[-1] == "[":
                stack.pop()

            else:
                stack.append(i)

        if i == ")":
            if stack and stack[-1] == "(":
                stack.pop()

            else:
                stack.append(i)

    if not stack:
        result.append("yes")

    if stack:
        result.append("no")

print(*result, sep="\n")
