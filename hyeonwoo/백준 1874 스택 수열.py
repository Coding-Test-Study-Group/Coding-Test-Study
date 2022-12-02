from collections import deque
import sys

input = sys.stdin.readline

n = int(input())

# 입력 받을 수열을 큐로 저장한다.
queue = deque([int(input()) for _ in range(n)])

stack = []  # LIFO 연산을 수행할 스택
num_list = []  # 스택에서 뽑은 수를 저장할 배열
answer = []  # 스택 연산에 따라 "+", "-"를 저장할 배열
i = 1
while True:
    # 스택이 비어있거나, 스택의 마지막과 수열의 처음이 다르면 스택에 i를 push한다.
    if not stack or stack[-1] != queue[0]:
        stack.append(i)
        answer.append("+")
        i += 1

    # 스택의 마지막과 수열의 처음이 같으면, 스택의 마지막과 수열의 처음을 pop한다.
    if stack[-1] == queue[0]:
        target = stack.pop()
        answer.append("-")

        num_list.append(target)

        queue.popleft()

        if not queue:
            break

    # 스택의 길이가 n보다 커지면 수열을 만들 수 없다고 판단한다.
    if len(stack) > n:
        answer = ["NO"]
        break

print(*answer, sep="\n")
