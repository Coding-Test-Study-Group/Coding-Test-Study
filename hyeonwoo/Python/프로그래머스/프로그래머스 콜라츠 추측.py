import unittest


def solution(num):
    answer = 0

    for chk in range(1, 500 + 1):
        # 500번을 시도해도 1이 되지 않는다면 -1 반환
        if chk == 500:
            return -1

        # 주어진 수가 1이 되는 경우 반복문 종료
        if num == 1:
            break

        # 주어진 수가 짝수라면 2로 나눈다.
        elif num % 2 == 0:
            num //= 2
            answer += 1

        # 주어진 수가 홀수라면 3을 곱하고 1을 더한다.
        elif num % 2 == 1:
            num = (num * 3) + 1
            answer += 1

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(solution(num=6), 8)
        self.assertEqual(solution(num=16), 4)
        self.assertEqual(solution(num=626331), -1)


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
