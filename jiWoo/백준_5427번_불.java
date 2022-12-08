package jiWoo;

import java.io.*;
import java.util.*;

public class 백준_5427번_불 {
    static Queue<int[]> que;
    static int[] x = { -1, 1, 0, 0 };
    static int[] y = { 0, 0, -1, 1 };
    static char[][] map;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());// 테스트 케이스
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            que = new LinkedList<>();

            map = new char[h][w];
            ArrayList<int[]> firelist = new ArrayList<>();

            // map에 값 넣고 que에 상근이 먼저 넣고 그 다음 불 넣기
            for (int a = 0; a < h; a++) {
                char[] c = br.readLine().toCharArray();

                for (int b = 0; b < w; b++) {
                    if (c[b] == '@') {
                        int[] sg = { a, b, 0 };
                        que.add(sg);
                    }
                    if (c[b] == '*') {
                        int[] fire = { a, b, -1 };
                        firelist.add(fire);
                    }

                    map[a][b] = c[b];
                }
            }

            for (int[] f : firelist) {
                que.add(f);
            }
            BFS();
        }

    }

    private static void BFS() {
        boolean escape = false;
        while (!que.isEmpty()) {

            int[] now = que.poll();
            int nx = now[0];
            int ny = now[1];
            if (map[nx][ny] == '*' && now[2] != -1)
                continue;
            // 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = nx + x[i];
                int nextY = ny + y[i];
                int next[] = { nextX, nextY, now[2] };

                // 나온 것이 상근이면 빈칸으로 다 옮기기
                // 빈칸이 없으면 그대로 , 그 다음이 바깥이면 탈출
                if (map[nx][ny] == '@') {
                    // 빈칸이면
                    if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] == '.') {

                        map[nextX][nextY] = '@';
                        int nex[] = { nextX, nextY, next[2] + 1 };
                        que.add(nex);
                    } else if (nextX < 0 || nextX == h || nextY < 0 || nextY == w) {
                        // 바깥이면
                        escape = true; // 성공
                        System.out.println(next[2] + 1);
                        return;
                    }
                } else { // 불이라면
                    if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] != '#'
                            && map[nextX][nextY] != '*') {
                        map[nextX][nextY] = '*';
                        que.add(next);
                    }
                }

                // 나온 것이 불이면 벽이 아니면(상근, 빈칸) 주변으로 다 옮기기
                // 큐가 성공하지 않고 끝나면 IMPOSSIBLE
            }

        }

        if (!escape) { // 상근이가 나가지 않았다면
            System.out.println("IMPOSSIBLE");
        }
    }
}