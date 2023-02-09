import unittest


def solution(numbers):
    # 예외 처리
    if set(numbers) == {0}:
        return "0"

    # 문자열 배열로 변환
    target = list(map(str, numbers))

    """
    배열에 담긴 숫자 중 가장 긴 자릿수(3자리)를 기준으로 정렬

    문자열 기준으로만 정렬하면 아래와 같은 예외 발생
    ex) ["34", "30", "3"] -> 34303

    따라서, numbers의 원소 중 가장 긴 자릿수를 기준으로 문자열을 늘려서 비교해준다.
    ex) ["343434", "303030", "333"] -> 343434333303030 (실제 출력 : 34330)
    """
    target.sort(key=lambda x: x * 3, reverse=True)

    answer = "".join(str for str in target)

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(solution(numbers=[6, 10, 2]), "6210")
        self.assertEqual(solution(numbers=[3, 30, 34, 5, 9]), "9534330")
        self.assertEqual(solution(numbers=[0, 0, 0]), "0")


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
