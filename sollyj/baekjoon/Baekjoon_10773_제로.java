// Baekjoon_10773_제로
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_10773_제로 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int K = Integer.parseInt(br.readLine());

			// 최근 수를 지우는 것이므로 선입후출 구조인 stack을 사용한다.
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < K; i++) {
				int num = Integer.parseInt(br.readLine());

				// 스택에 값 넣다 빼기
				if (num == 0) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}

			int sum = 0;
			while (!stack.isEmpty()) {    // 나머지 수들을 더한다.
				sum += stack.pop();
			}

			System.out.println(sum);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
