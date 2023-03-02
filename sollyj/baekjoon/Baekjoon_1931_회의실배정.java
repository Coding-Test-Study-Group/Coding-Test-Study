// Baekjoon_1931_회의실배정
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_1931_회의실배정 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			int N = Integer.parseInt(br.readLine());

			int[][] conference = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				conference[i][0] = Integer.parseInt(st.nextToken());
				conference[i][1] = Integer.parseInt(st.nextToken());
			}

			// 정렬 수행
			Arrays.sort(conference, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {    // 끝나는 시간이 같으면
						return o1[0] - o2[0];    // 시작 시간이 빠른 순서대로 정렬
					} else {
						return o1[1] - o2[1];    // 끝나는 시간이 빠른 순서대로 정렬
					}
				}
			});

			int end = -1;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (conference[i][0] >= end) {
					count++;
					end = conference[i][1];
				}
			}

			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
