from collections import deque

def solution(numbers, target):
    q = deque()
    q.append((0, 0))
    
    answer = 0
    while q:
        cur, idx = q.popleft()
        if idx == len(numbers):
            if cur == target:
                answer += 1
        else:
            q.append((cur + numbers[idx], idx + 1))
            q.append((cur - numbers[idx], idx + 1))
    return answer