// Baekjoon_11724_연결요소의개수
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11724_연결요소의개수 {
    static boolean visited[];   // 방문 기록 배열
    static ArrayList<Integer>[] A;  // 인접리스트

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        A = new ArrayList[N+1];

        // 리스트 초기화 해주기
        for(int i=0; i<N+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // 인접리스트에 값 넣어주기
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 방향없는 그래프이므로 둘다 넣어준다.
            A[a].add(b);
            A[b].add(a);    
        }

        int count = 0;   // 연결 요소 개수

        // 1~N까지 돌면서 깊이 우선 탐색을 한다.
        // DFS가 끝날때 까지 탐색한 모든 노드집합을 하나의 연결요소로 판단
        // 방문하지 않은 노드가 있다는 건 연결 요소 개수가 +1
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    // 깊이우선탐색 함수
    // i 방문 여부를 알려준다
    private static void DFS(int i) {
        if(visited[i])  return;

        visited[i] = true;
        for(int k : A[i]) {
            if(visited[k] == false) {   // i의 인접 노드 중 방문 하지 않은 노드 탐색 -> 깊이 우선 탐색!
                DFS(k); // 재귀형태로 구현
            }
        }
    }
}
