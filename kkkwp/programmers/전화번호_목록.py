def solution(phone_book):
    hash_map = {}
    for phone in phone_book:
        hash_map[phone] = 1
    for phone in phone_book:
        check = ""
        for p in phone:
            check += p
            if check in hash_map and check != phone:
                return False
    return True