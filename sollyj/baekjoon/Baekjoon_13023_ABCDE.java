// Baekjoon_13023_ABCDE
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_13023_ABCDE {
    public static boolean visited[];   // 방문 기록 배열
    public static ArrayList<Integer>[] A;   // 인접리스트
    public static boolean arrive = false;   // 도착했는지 안했는지 depth가 5이상이면 true

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // visited 배열 초기화
        visited = new boolean[N];

        // 사람수만큼 인접리스트 초기화
        A = new ArrayList[N];
        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // 인접리스트에 값 넣어주기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);    // 양방향 그래프
        }

        // 깊이우선탐색을 하며 깊이를 카운트 한다
        for(int i=0; i<N; i++) {
            DFS(i, 1);
            if(arrive)  break;
        }

        if(arrive)  System.out.println("1");
        else    System.out.println("0");
    }

    private static void DFS(int now, int depth) {
        if(depth >= 5 || arrive) {
            arrive = true;
            return;
        }

        visited[now] = true;

        for(int k : A[now]) {   // 인접 노드들을 탐색(깊이 우선 탐색)
            if(!visited[k]) {
                DFS(k, depth+1);
            }
        }
        visited[now] = false;
    }
}