package sollyj.programmers;

public class Programmers_콜라츠추측 {
	public static void main(String[] args) {
		System.out.println(solution(626331));
	}

	private static int solution(int num) {
		int answer = 0;
		long n = num;    // 입력값이 크면 연산을 하다가 값이 커져 int 오버플로우 현상이 나타난다. 그래서 long형으로 임의로 바꿔주였다.

		while (answer <= 500) {
			if (n == 1) {
				break;
			}

			if (n % 2 == 0) {
				n /= 2;
			} else {
				n *= 3;
				n += 1;
			}

			answer++;
		}

		if (answer > 500)
			answer = -1;

		return answer;
	}
}
