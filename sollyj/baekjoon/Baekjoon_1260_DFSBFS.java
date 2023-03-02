// Baekjoon_1260_DFSBFS
package sollyj.baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_1260_DFSBFS {
    public static ArrayList<Integer>[] A;   // 인접리스트
    public static boolean[] visited;    // 방문기록배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());   // 시작할 정점

        A = new ArrayList[N+1];

        // 인접리스트 초기화
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // 인접리스트 값 넣어주기
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        // 번호가 작은 것을 먼저 방문하기 위해 오름차순 정렬
        for(int i=1; i<=N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        System.out.println();

        visited = new boolean[N+1];
        BFS(V);
        System.out.println();
    }

    // 깊이우선탐색 함수
    private static void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int i : A[node]) {
            if(!visited[i]) {   // i의 인접 노드 중 방문 하지 않은 노드 탐색 -> 깊이 우선 탐색!
                DFS(i); // 재귀형태로 구현
            }
        }
    }

    // 너비우선탐색 함수
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();   // BFS할 큐

        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()) {
            int newNode = queue.poll();
            System.out.print(newNode + " ");

            for(int i : A[newNode]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
