// Baekjoon_2343_기타레슨
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2343_기타레슨 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());    // 강의 수
			int M = Integer.parseInt(st.nextToken());    // 블루레이 수

			st = new StringTokenizer(br.readLine());

			int[] videos = new int[N];    // 강의 길이 배열

			int end = 0;    // 강의 길이 다 더한 것: 블루레이 크기의 최댓값
			int start = Integer.MIN_VALUE;    // 강의 길이 최댓값 : 블루레이 크기의 최솟값

			for (int i = 0; i < N; i++) {
				videos[i] = Integer.parseInt(st.nextToken());

				end += videos[i];
				if (start < videos[i])
					start = videos[i];
			}

			// 이분 탐색
			while (start <= end) {
				int mid = (start + end) / 2;    // 중간값
				int cnt = 0;    // 블루레이 수 카운트
				int sum = 0;

				// cnt 구하기
				for (int i = 0; i < N; i++) {
					if (sum + videos[i] > mid) {    // sum이 mid보다 커지면
						cnt++;    // 여기까지 블루레이 크기 이므로 카운트
						sum = 0;    // sum 0으로 초기화해서 강의 다시 셈
					}
					sum = sum + videos[i];
				}

				// sum이 0으로 초기화 되지 않고 종료되었으므로 블루레이수 +1
				if (sum != 0)
					cnt++;

				if (cnt <= M)    // 블루레이 수가 M개 이하면
					end = mid - 1;    // 중간값 왼쪽 set 탐색
				else    // 블루레이 수가 M개 초과면
					start = mid + 1;    // 중간값 오른쪽 set 탐색
			}

			System.out.println(start);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
