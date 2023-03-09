import unittest


# 홀수 확인 함수
def is_odd(number):
    return number % 2 == 1


# 짝수 확인 함수
def is_even(number):
    return number % 2 == 0


def solution(s):
    answer = ""

    # 단어를 기준으로 몇 번째 문자인지 확인하는 변수
    idx = 1
    for character in s:
        # 문자가 공백이라면 정답 변수에 추가한 뒤 인덱스를 1로 만든 뒤 다음 반복문 실행
        if character == " ":
            answer += character
            idx = 1
            continue

        # 문자열이 홀수번째라면 대문자로 바꾼 뒤 정답 변수에 추가
        if is_odd(idx):
            answer += character.upper()

        # 문자열이 짝수번째라면 소문자로 바꾼 뒤 정답 변수에 추가
        if is_even(idx):
            answer += character.lower()

        # 다음 반복문 실행 전 인덱스를 증가시켜준다.
        idx += 1

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(solution(s="try hello world"), "TrY HeLlO WoRlD")


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
