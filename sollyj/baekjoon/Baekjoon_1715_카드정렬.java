// Baekjoon_1715_카드정렬
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon_1715_카드정렬 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			// 우선순위 큐 선언
			PriorityQueue<Integer> cardSize = new PriorityQueue<>(N);
			for (int i = 0; i < N; i++) {
				cardSize.add(Integer.parseInt(br.readLine()));    // 자동으로 오름차순 정렬로 큐에 들어가짐
			}

			int count = 0;
			while (cardSize.size() != 1) {
				int data1 = cardSize.poll();
				int data2 = cardSize.poll();
				count += data1 + data2;
				cardSize.add(data1 + data2);
			}

			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
