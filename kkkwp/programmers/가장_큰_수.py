def solution(numbers):
    numbers = sorted(list(map(str, numbers)), key=lambda x: x * 3, reverse=True)
    return str(int(''.join(numbers)))