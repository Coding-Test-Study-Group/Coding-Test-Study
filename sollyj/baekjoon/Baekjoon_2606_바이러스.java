// Baekjoon_2606_바이러스
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_2606_바이러스 {
	public static ArrayList<Integer>[] A;
	public static boolean[] visited;
	public static int count = 0;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			int N = Integer.parseInt(br.readLine());   // 컴퓨터 개수
			int pair = Integer.parseInt(br.readLine());
			A = new ArrayList[N + 1];    // 인접리스트
			visited = new boolean[N + 1];

			// 인접리스트 초기화
			for (int i = 1; i <= N; i++) {
				A[i] = new ArrayList<>();
			}

			// 인접리스트에 값 넣어주기
			for (int i = 1; i <= pair; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());    // 인덱스
				int b = Integer.parseInt(st.nextToken());    // 해당 인덱스에 접해있는 값
				A[a].add(b);
				A[b].add(a);
			}

			// 리스트 배열 오름차순
			for (int i = 1; i <= N; i++) {
				Collections.sort(A[i]);
			}

			DFS(1);    // 1번 컴퓨터와 인접해있는 컴퓨터를 알아본다. (DFS)

			System.out.println(count - 1);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	private static void DFS(int com) {
		visited[com] = true;
		count++;

		for (int i : A[com]) {
			if (!visited[i]) {    // i의 인접 노드 중 방문 하지 않은 노드 탐색 -> 깊이 우선 탐색!
				DFS(i);    // 재귀형태로 구현
			}
		}
	}
}