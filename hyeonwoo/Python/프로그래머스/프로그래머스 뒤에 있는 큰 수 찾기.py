import unittest


def solution(numbers):
    len_numbers = len(numbers)
    # numbers 배열의 길이 만큼 -1로 채워준다.
    answer = [-1 for _ in range(len(numbers))]

    # numbers 배열의 인덱스를 담을 스택
    stack = []
    for idx in range(len_numbers):
        # 현재 숫자
        number = numbers[idx]

        # 스택이 비어있거나 스택의 마지막 인덱스의 숫자가 현재 숫자보다 크면 반복문 종료
        while stack and numbers[stack[-1]] < number:
            # 스택이 비어있지 않거나 스택의 마지막 인덱스의 숫자가 현재 숫자보다 작다면
            # 스택의 마지막 인덱스를 pop하고, 정답 배열의 인덱스에 현재 숫자를 넣는다.
            answer[stack.pop()] = number

        # 반복문이 종료된 후 스택에 인덱스 추가
        stack.append(idx)

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(solution(numbers=[2, 3, 3, 5]), [3, 5, 5, -1])
        self.assertEqual(solution(numbers=[9, 1, 5, 3, 6, 2]), [-1, 5, 6, 6, -1, -1])


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
