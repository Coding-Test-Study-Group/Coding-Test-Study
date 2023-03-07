from itertools import permutations

def isPrime(num):
    if num < 2:
        return False
    for i in range(2, int(pow(num, 0.5)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    nums = set()
    for i in range(1, len(numbers) + 1):
        for j in list((permutations(numbers, i))):
            nums.add(int(''.join(j)))
    for num in nums:
        if isPrime(num):
            answer += 1
    return answer