from collections import deque

def solution(priorities, location):
    docs = deque()
    for idx, priority in enumerate(priorities):
        docs.append((priority, idx))
    cnt = 0
    while docs:
        j = docs.popleft()
        if docs and max(docs)[0] > j[0]:
            docs.append(j)
        else:
            cnt += 1
            if docs[1] == location:
                break
    return cnt