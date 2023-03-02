// Baekjoon_1388_바닥장식
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1388_바닥장식 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;

			// 2차원 배열에 바닥장식모양 넣기
			char[][] deco = new char[N][M];
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < M; j++) {
					deco[i][j] = row.charAt(j);
				}
			}

			// - 개수 구하기
			for (int i = 0; i < N; i++) {    // 가로방향으로 탐색한다
				int tmp = 0;    // -과 |를 구분해주는 임시변수
				for (int j = 0; j < M; j++) {
					if (deco[i][j] == '|') {
						tmp = 0;
					} else if (++tmp == 1) {
						count++;
					}
				}
			}

			// | 개수 구하기
			for (int j = 0; j < M; j++) {    // 세로방향으로 탐색한다
				int tmp = 0;
				for (int i = 0; i < N; i++) {
					if (deco[i][j] == '-') {
						tmp = 0;
					} else if (++tmp == 1) {
						count++;
					}
				}
			}

			System.out.println(count);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}