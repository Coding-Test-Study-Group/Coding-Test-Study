// Baekjoon_3273_두수의합
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_3273_두수의합 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int len = n;

			ArrayList<Integer> numList = new ArrayList<>(len);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				numList.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(numList);    // 오름차순: 투포인터로 합을 x와 비교해 나갈 것이기 때문에

			// 투포인터
			int pointer1 = 0;
			int pointer2 = len - 1;
			int count = 0;    // 결과값

			int x = Integer.parseInt(br.readLine());

			while (pointer1 < pointer2) {
				int sum = numList.get(pointer1) + numList.get(pointer2);
				if (sum > x) {
					pointer2--;
				} else if (sum < x) {
					pointer1++;
				} else {
					count++;
					pointer1++;
					pointer2--;
				}
			}

			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
