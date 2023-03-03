import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    days = deque()
    for progress, speed in zip(progresses, speeds):
        days.append(math.ceil((100 - progress) / speed))
    while days:
        cnt = 1
        deploy = days.popleft()
        while days and deploy >= days[0]:
            days.popleft()
            cnt += 1
        answer.append(cnt)
    return answer