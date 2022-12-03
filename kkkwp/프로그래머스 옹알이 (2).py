def solution(babbling):
    answer = 0
    words = ['aya', 'ye', 'woo', 'ma']
    for babble in babbling:
        for word in words:
            if word * 2 not in babble:
                babble = babble.replace(word, ' ')
        if len(babble.strip()) == 0:
            answer += 1
    return answer