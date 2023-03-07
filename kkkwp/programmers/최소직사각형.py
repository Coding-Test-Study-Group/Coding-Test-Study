def solution(sizes):
    max_w = 0
    max_h = 0
    for w, h in sizes:
        if w < h:
            w, h = h, w
        max_w = max(max_w, w)
        max_h = max(max_h, h)
    return max_w * max_h