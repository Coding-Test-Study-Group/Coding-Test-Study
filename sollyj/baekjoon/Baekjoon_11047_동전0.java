// Baekjoon_11047_동전0
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11047_동전0 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] value = new int[N];
			for (int i = 0; i < N; i++) {
				value[i] = Integer.parseInt(br.readLine());
			}

			int j = N - 1;
			int result = 0;

			while (true) {
				int q = K / value[j];    // 몫
				int r = K % value[j];    // 나머지

				if (q > 0) {    // 몫이 나오면
					result = result + q;
					K = r;
				}

				if (r == 0)    // 나머지가 0이면 반복문 중단
					break;

				j--;
			}

			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
