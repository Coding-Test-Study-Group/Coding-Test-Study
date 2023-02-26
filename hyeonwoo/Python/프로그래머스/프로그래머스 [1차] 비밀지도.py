import unittest


# 문자를 바꿔주는 함수
def decode_map(string):
    # 변환 테이블
    # str.maketrans("바꿀문자", "새로운문자")
    table = str.maketrans("01", " #")

    # 문자열 변수 string에서 문자 "0"을 " "로, "1"을 "#"으로 바꾼다.
    # ex) "10101" -> "# # #"
    return string.translate(table)


def solution(n, arr1, arr2):
    # 각 정수 배열 원소의 OR 연산 결과를 2진수 문자열로 변환하여 리스트에 저장
    target = [format((arr1[i] | arr2[i]), "b") for i in range(n)]

    # 위에서 계산한 2진수 값은 101, 1과 같이 자릿수가 다르기 때문에
    # target 배열의 원소 중 가장 긴 자릿수를 구한다.
    max_len = max([len(i) for i in target])

    # 가장 긴 자릿수만큼 2진수 문자열 앞 부분에 0을 채워준다.
    result = [i.zfill(max_len) for i in target]

    # decode_map 함수를 통해 "0" -> " ", "1" -> "#"로 바꿔준다.
    answer = [decode_map(string) for string in result]

    return answer


class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(
            solution(n=5, arr1=[9, 20, 28, 18, 11], arr2=[30, 1, 21, 17, 28]),
            ["#####", "# # #", "### #", "#  ##", "#####"],
        )
        self.assertEqual(
            solution(n=6, arr1=[46, 33, 33, 22, 31, 50], arr2=[27, 56, 19, 14, 14, 10]),
            ["######", "###  #", "##  ##", " #### ", " #####", "### # "],
        )


if __name__ == "__main__":
    runner = unittest.TextTestRunner()
