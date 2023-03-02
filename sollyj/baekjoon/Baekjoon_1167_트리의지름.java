// Baekjoon_1167_트리의지름
package sollyj.baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_1167_트리의지름 {
    public static boolean[] visited;
    public static int[] distance;
    public static ArrayList<Edge>[] A;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        // 전역에 선언한 변수들 초기화
        visited = new boolean[V+1];
        distance = new int[V+1];
        
        // 인접리스트 초기화
        A = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            A[i] = new ArrayList<Edge>();
        }

        // 인접리스트에 데이터 저장
        for(int i=1; i<=V; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            while(true) {
                int node = Integer.parseInt(st.nextToken());
                if(node == -1)  break;
                
                int distance = Integer.parseInt(st.nextToken());
                A[k].add(new Edge(node, distance));
            }
        }

        BFS(1);

        int max = 1;
        // distance 배열에서 가장 큰 값으로 다시 시작점 설정
        for(int i=2; i<=V; i++) {
            if(distance[i] > distance[max]) 
                max = i;
        }

        visited = new boolean[V+1];
        distance = new int[V+1];
        BFS(max);   // 새로운 시작점으로 다시 실행해서 distance배열 채우기
        
        // distance배열 오름차순 정렬 후 마지막 값 출력
        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int newNode = queue.poll();

            for(Edge instance : A[newNode]) {
                int instanceNode = instance.node;
                int instanceDist = instance.distance;

                if(!visited[instanceNode]) {
                    visited[instanceNode] = true;
                    queue.add(instanceNode);
                    distance[instanceNode] = distance[newNode] + instanceDist;   // 현재 노드와 instance의 노드는 연결되어있으므로 instance의 distance를 더해준다.
                }
            }
        }
    }
}

class Edge {
    int node, distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
