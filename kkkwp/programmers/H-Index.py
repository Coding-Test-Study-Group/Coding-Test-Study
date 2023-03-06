def solution(citations):
    n = len(citations)
    citations.sort()
    h_index = 0
    for i in range(n):
        h = min(citations[i], n - i)
        h_index = max(h_index, h)
    return h_index