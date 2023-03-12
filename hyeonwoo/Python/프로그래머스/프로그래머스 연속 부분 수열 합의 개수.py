import unittest
from itertools import cycle


def solution(elements):
    answer = 0

    # 모든 부분 수열의 합의 개수를 저장할 집합
    result = set()

    # 수열의 전체 원소 개수
    total_elements = len(elements)

    # 전체 원소 개수 만큼 반복
    for length in range(1, total_elements + 1):
        # 원형 수열 생성
        seq = cycle(elements)

        # 원형 수열에서 모든 원소가 담긴 elemetns 리스트의 마지막 원소를 기준으로
        # (현재 길이 - 1)만큼 늘어난 수열 생성
        target_seq = [next(seq) for _ in range(total_elements + length - 1)]

        # 타겟 수열의 전체 원소 개수
        total_target_seq = len(target_seq)

        # 타겟 수열의 원소 개수 만큼 반복
        for i in range(total_target_seq):
            # 현재 인덱스부터 현재 길이만큼의 부분 수열 생성
            sub_seq = target_seq[i : i + length]

            # 부분 수열의 길이가 현재 길이보다 작으면 반복문 종료
            if len(sub_seq) < length:
                break

            # 현재 길이 만큼의 부분 수열 합 저장
            result.add(sum(sub_seq))

    answer = len(result)

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(solution(elements=[7, 9, 1, 1, 4]), 18)


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
