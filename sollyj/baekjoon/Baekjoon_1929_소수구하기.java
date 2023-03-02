// Baekjoon_1929_소수구하기
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1929_소수구하기 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] nums = new int[N + 1];    // 소수 판별하기 위해 필요한 리스트

			// 1부터 N까지 배열에 넣기
			for (int i = 2; i <= N; i++) {
				nums[i] = i;
			}

			// 소수 아닌 수 0으로 만들어 리스트에서 제거
			// N의 제곱근까지만 탐색해도 된다.
			// N이 서로 다른 수 a*b라고 했을때 a,b 모두 N의 제곱근보다 클 수 없기때문에
			for (int i = 2; i <= Math.sqrt(N); i++) {
				if (nums[i] == 0)
					continue;

				// i의 배수 지우기
				for (int j = i + i; j <= N; j += i) {
					nums[j] = 0;
				}
			}

			// 소수 출력
			for (int i = M; i <= N; i++) {
				if (nums[i] != 0)
					System.out.println(nums[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
