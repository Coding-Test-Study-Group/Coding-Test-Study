// Baekjoon_1456_거의소수
package sollyj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1456_거의소수 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			int count = 0;
			int[] nums = new int[10000001];
			int len = nums.length;

			// 1부터 10^7 까지 수 초기화
			for (int i = 1; i < len; i++) {
				nums[i] = i;
			}

			// 소수를 다 찾는다.
			for (int i = 2; i < Math.sqrt(len); i++) {
				if (nums[i] == 0)
					continue;

				for (int j = i + i; j < len; j += i) {
					nums[j] = 0;
				}
			}

			// 거의 소수를 찾는다.
			for (int i = 2; i < len; i++) {
				if (nums[i] != 0) {    // 소수 이면
					long np = i;

					// while문 안에 조건을 다 넣으면 안되는 이유:
					// np의 제곱을 하면서 A보다 큰수를 구해야 하는데 while문 안에 조건을 다 넣어버리면 np가 A보다 작으면 그 np는 그냥 건너뛰어버린다.
					// while ((double)A / (double)np <= (double)i && (double)i <= (double)B / (double)np) {
					// 	count++;
					// 	np = np * i;    // 제곱수
					// }

					while ((double)i <= (double)B / (double)np) {
						if ((double)A / (double)np <= (double)i) {    // A~B사이의 수 라면
							count++;
						}
						np = np * i;
					}
				}
			}

			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
