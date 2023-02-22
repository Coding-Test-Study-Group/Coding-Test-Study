// Baekjoon_18352_특정거리의도시찾기
package sollyj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_18352_특정거리의도시찾기 {
	static ArrayList<Integer>[] streetGraph;    // 도로그래프 만들기 위한 인접리스트
	static int[] visited;    // 방문 횟수 배열

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());    // 도시(노드) 개수
			int M = Integer.parseInt(st.nextToken());    // 도로(선) 개수
			int K = Integer.parseInt(st.nextToken());    // 최단 거리
			int X = Integer.parseInt(st.nextToken());    // 출발 도시 번호

			ArrayList<Integer> answer = new ArrayList<>();

			// 인접리스트 초기화
			streetGraph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				streetGraph[i] = new ArrayList<Integer>();
			}

			// 도로 그래프 생성
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				streetGraph[a].add(b);
			}

			// visited 배열 초기화
			visited = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				visited[i] = -1;
			}

			BFS(X);    // 너비우선탐색으로 방문횟수세기

			for (int i = 0; i <= N; i++) {
				if (visited[i] == K) {
					answer.add(i);
				}
			}

			if (answer.isEmpty()) {
				System.out.println("-1");
			} else {
				Collections.sort(answer);
				for (int i : answer)
					System.out.println(i);
			}

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();   // BFS할 큐

		visited[node]++;    // 방문 횟수+1
		queue.add(node);

		while (!queue.isEmpty()) {
			int newNode = queue.poll();

			for (int i : streetGraph[newNode]) {
				if (visited[i] == -1) {
					visited[i] = visited[newNode] + 1;
					queue.add(i);
				}
			}
		}
	}
}