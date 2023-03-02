// Baekjoon_5427_불
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_5427_불 {
    static int w, h;
    static char[][] map;
    static Queue<Point> fire;   // 불의 위치 큐
    // 불, 상근 움직이기 위한 x, y 좌표
    static int[] dx = {-1, 1, 0, 0};    // 행
    static int[] dy = {0, 0, -1, 1};    // 열
    static boolean[][] visited;
    static StringBuffer sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuffer();

        int testcase = Integer.parseInt(br.readLine());
        int sg_x = 0, sg_y = 0;   // 상근이 위치

        // 각 테스트케이스 수행
        for(int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            fire = new LinkedList<>();  // 불의 위치 큐 초기화

            // map에 데이터 넣기
            for(int j=0; j<h; j++) {    // 행
                String str = br.readLine();
                for(int k=0; k<w; k++) {    // 열
                    map[j][k] = str.charAt(k);

                    // 큐에 불의 위치 넣어주기
                    if(map[j][k] == '*'){
                        fire.add(new Point(j, k));
                    }

                    if(map[j][k] == '@') {
                        sg_x = j;   sg_y = k;
                    }
                }
            }
            escape(sg_x, sg_y);   // 상근이 탈출
        }

        System.out.println(sb.toString());
        br.close();
    }

    // 불을 번지게 할 메서드
    private static void burn() {
        int size = fire.size();

        for(int i=0; i<size; i++) {
            Point now = fire.poll();   // 불 위치 바꾸기 위해 큐에서 빼주기

            // now에서 동서남북 이동하기
            for(int j=0; j<4; j++) {
                int nx = now.x + dx[j];
                int ny = now.y + dy[j];

                // 불을 번질수 있는 조건 (불이 번지는 곳은 .과 @이다)
                if(nx>=0 && ny>=0 && nx<h && ny<w && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                    fire.offer(new Point(nx, ny));   // 연산하고 다시 넣어주기
                    map[nx][ny] = '*';   // 불 번짐
                }
            }
        }
    }

    // 탈출할 메서드
    // 현재 상근위치를 매개변수로 받음
    private static void escape(int x, int y) {
        Queue<Point> q = new LinkedList<>();   // 선 불번짐, 후 상근 위치 옮기기할 큐(선입선출)
        visited = new boolean[h][w];
        int time = -1;

        q.offer(new Point(-1, -1));   // 의도적으로 (-1, -1)을 넣어준 이유는 상근 이동 전 불 번지게 하기 위해
        q.offer(new Point(x, y));

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.x == -1 && now.y == -1) {
                burn();   // 불번짐

                // 큐에 값이 있다면(== 상근이가 탈출 못했다면)
                // (-1, -1) 또 넣어준다.
                if(!q.isEmpty())    q.offer(now);

                time++;
                continue;
            }

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx>=h || ny>=w || nx<0 || ny<0) {    // 탈출했다면
                    sb.append(time+1 + "\n");
                    return;
                }
                if(map[nx][ny] == '.' && !visited[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        sb.append("IMPOSSIBLE\n");
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

