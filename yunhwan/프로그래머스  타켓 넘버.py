def solution(numbers, target):
    answer = 0
    stack = []

    def find(numbers, v, result):
        if v == len(numbers):
            if result == target:
                stack.append(0); return 1;
            else:
                return 0

        find(numbers, v + 1, result + numbers[v])
        find(numbers, v + 1, result - numbers[v])

    find(numbers, 0, 0)
    answer = len(stack)
    return answer