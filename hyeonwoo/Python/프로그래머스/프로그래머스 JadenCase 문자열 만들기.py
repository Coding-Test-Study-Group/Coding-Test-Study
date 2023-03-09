import unittest


def solution(s):
    answer = ""

    # 공백 체크용 변수
    # 초기값을 1로 두어 첫 번째 문자가 알파벳 소문자일 경우, 대문자로 변환해주기 위함
    space_chk = 1

    # 문자열을 순회
    for target in s:
        # 현재 문자가 공백이면 공백 체크용 변수 1 증가
        # 공백 체크 후, 정답 변수에 현재 문자를 추가해준 뒤, 다음 반복문 실행
        if target == " ":
            space_chk += 1
            answer += target
            continue

        # 공백 체크용 변수가 0보다 클 경우,
        # 이전 문자가 공백이므로 현재 문자를 대문자로 변환해준다.
        # 정답 변수에 대문자로 변환한 현재 문자를 추가해준 뒤, 공백 체크용 변수를 0으로 초기화
        if space_chk > 0:
            answer += target.upper()
            space_chk = 0
            continue

        # 문자가 숫자일 경우(현재 문자의 아스키 값이 65보다 작다면)
        # 정답 변수에 현재 문자를 추가해준 뒤, 다음 반복문 실행
        # (알파벳 소문자의 아스키 값은 65 ~ 90, 대문자의 아스키 값은 95 ~ 122)
        if ord(target) < 65:
            answer += target
            continue

        # 위 세 개의 조건에 해당하지 않는 경우
        # 정답 변수에 소문자로 변환한 현재 문자를 추가해준다.
        answer += target.lower()

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(solution(s="3people unFollowed me"), "3people Unfollowed Me")
        self.assertEqual(solution(s="for the last week"), "For The Last Week")


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
