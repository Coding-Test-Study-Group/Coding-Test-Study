def strings_xor(s, t):
    res = ""
    for i in range(len(s)):
        if s[i] != t[i]:  # original code: if s[i] = t[i], modify: = -> !=
            res += "1"
            # original code: res = '0', modify: = '0' -> += '1'
        else:
            res += "0"
            # original code: res = '1', modify: = '1' -> += '0'

    return res


s = input()
t = input()
print(strings_xor(s, t))
