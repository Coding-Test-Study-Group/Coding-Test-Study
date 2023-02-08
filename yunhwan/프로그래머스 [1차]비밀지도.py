def solution(n, arr1, arr2):
    answer = []

    binary1 = []
    binary2 = []

    # 2진수 변환
    def convertBinary(x):
        binary = ''
        cur = x
        for i in range(n - 1, -1, -1):
            if cur >= 2 ** i:
                binary += '1'
                cur -= 2 ** i
            else:
                binary += '0'

        return binary

    for i in range(n):
        binary1.append(convertBinary(arr1[i]))
        binary2.append(convertBinary(arr2[i]))

    # 변환된 두 2진수를 or 연산
    for i in range(n):
        map = ''
        for j in range(n):
            if int(binary1[i][j]) or int(binary2[i][j]):
                map += '#'
            else:
                map += ' '
        answer.append(map)

    return answer