// Baekjoon_1744_수묶기
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon_1744_수묶기 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			// 우선순위 큐
			PriorityQueue<Integer> posQ = new PriorityQueue<>(Collections.reverseOrder());    // 양수는 내림차순으로 저장
			PriorityQueue<Integer> negQ = new PriorityQueue<>();    // 음수는 오름차순으로 저장

			int result = 0;

			int zeCnt = 0, oneCnt = 0;

			// 양수, 음수, 1, 0 나눠서 저장
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());

				if (num > 1) {
					posQ.add(num);
				} else if (num < 0) {
					negQ.add(num);
				} else if (num == 1) {
					oneCnt++;
				} else {
					zeCnt++;
				}
			}

			// 양수 처리
			while (posQ.size() > 1) {    // posQ가 비기 전까지
				int first = posQ.remove();
				int second = posQ.remove();

				result += first * second;
			}
			if (!posQ.isEmpty()) {    // 아직도 남아있다면
				result += posQ.remove();
			}

			// 음수 처리
			// 0 처리와 동시에
			while (negQ.size() > 1) {    // negQ가 비기 전까지
				int first = negQ.remove();
				int second = negQ.remove();

				result += first * second;
			}
			if (!negQ.isEmpty()) {    // 아직도 남아있다면
				if (zeCnt == 0) {    // 0이 없다면
					result += negQ.remove();
				}
				// 0이 있다면 어차피 0을 곱해 0을 더하는 것이므로 result에 따로 연산을 해줄 필요가 없다.
			}

			System.out.println(result + oneCnt);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
