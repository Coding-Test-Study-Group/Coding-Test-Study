// Programmers_하샤드수
package sollyj.programmers;

public class Programmers_하샤드수 {
	public static void main(String[] args) {
		System.out.println(solution(18));
	}

	private static boolean solution(int x) {
		boolean answer = true;

		int digit_sum = 0;
		int num = x;
		while (true) {
			if (num == 0)
				break;

			digit_sum += (num % 10);

			num /= 10;
		}

		if (x % digit_sum != 0)
			answer = false;

		return answer;
	}
}
