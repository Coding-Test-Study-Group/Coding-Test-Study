import sys


def reverse_number(n):
    return str(n)[::-1]


def get_even_front_number(num):
    result = ""

    num = str(num)
    num_len = len(num)

    result += num[: num_len // 2]

    return result


def get_even_back_number(num):
    result = ""

    num = str(num)
    num_len = len(num)

    result += num[num_len // 2 :]

    return result


def get_odd_front_number(num):
    result = ""

    num = str(num)
    num_len = len(num)

    result += num[: (num_len - 1) // 2]

    return result


def get_odd_back_number(num):
    result = ""

    num = str(num)
    num_len = len(num)

    result += num[(num_len + 1) // 2 :]

    return result


def is_odd_digit(num):
    return len(str(num)) % 2 == 1


def is_even_digit(num):
    return len(str(num)) % 2 == 0


def is_palindrome(num):
    result = 0

    if num < 10:
        result = True

    elif is_odd_digit(num):
        if get_odd_front_number(num) == reverse_number(get_odd_back_number(num)):
            result = True

        else:
            result = False

    elif is_even_digit(num):
        if get_even_front_number(num) == reverse_number(get_even_back_number(num)):
            result = True

        else:
            result = False

    return result


input = sys.stdin.readline

while True:
    num = int(input())

    if num == 0:
        break

    if is_palindrome(num):
        print("yes")
    else:
        print("no")
