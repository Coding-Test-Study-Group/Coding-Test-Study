

import java.io.*;
import java.util.*;

public class 백준_10026번_적록색약 {
    static int[] x = { -1, 1, 0, 0 };
    static int[] y = { 0, 0, -1, 1 };
    static int[][] visited;
    static char[][] space;
    static int max = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new char[N][N];
        visited = new int[N][N];
        int visited2[][] = new int[N][N];
        char[][] space2 = new char[N][N]; // 적록색약용
        for (int i = 0; i < N; i++) { // 구역 배열과 방문 배열 값 입력
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                space[i][j] = c[j];
                visited[i][j] = 0; // 0으로 입력 (방문 안했음)
                if (c[j] == 'G') {
                    space2[i][j] = 'R';
                } else
                    space2[i][j] = c[j];
                visited2[i][j] = 0;
            }
        }

        Queue<int[]> que = new LinkedList<>();
        int ad[] = { 0, 0 };
        visited[0][0] = 1;
        max = 1;
        que.add(ad);
        BFS(que);
        int not = max;

        que = new LinkedList<>();
        max = 1;
        space = space2;
        visited = visited2;
        visited[0][0] = 1;
        que.add(ad);
        BFS(que);
        System.out.println(not + " " + max);
    }

    private static void BFS(Queue<int[]> que) {
        Queue<int[]> que2 = new LinkedList<>();
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nx = now[0];
            int ny = now[1];
            char nColor = space[nx][ny];
            // 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {

                int nextX = nx + x[i];
                int nextY = ny + y[i];
                int[] next = { nextX, nextY };
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && visited[nextX][nextY] == 0) {
                    // 색이 같다면 now의 방문 숫자를 넣어준다!
                    if (space[nextX][nextY] == nColor) {
                        visited[nextX][nextY] = visited[nx][ny];
                        que.add(next);
                    } else { // 색이 같지 않다면
                        que2.add(next);
                    }
                }
            }
            if (que.isEmpty() && !que2.isEmpty()) {
                while (!que2.isEmpty()) {
                    int[] nad = que2.poll();
                    if (visited[nad[0]][nad[1]] == 0) {
                        que.add(nad);
                        max++;
                        visited[nad[0]][nad[1]] = max;
                        break;
                    }
                }
            }
        }

    }
}