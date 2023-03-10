// Programmers_시저암호
package sollyj.programmers;

public class Programmers_시저암호 {
	public static void main(String[] args) {
		String input1 = "AB";
		String input2 = "z";
		String input3 = "a B z";

		System.out.println(solution(input3, 4));
	}

	private static String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char nc = c;

			if (c == ' ') {
				answer += " ";
				continue;
			}

			int count = 0;

			while (count < n) {
				count++;

				if (nc == 'z') {
					nc = 'a';
				} else if (nc == 'Z') {
					nc = 'A';
				} else {
					nc = (char)(nc + 1);
				}
			}

			answer += String.valueOf(nc);
		}

		return answer;
	}
}
