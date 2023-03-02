// Baekjoon_2178_미로
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178_미로 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] miro = new char[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                miro[i][j] = str.charAt(j);
            }
        }

        Queue<Where> queue = new LinkedList<>();
        int[][] dist = new int[N][M];   // 방문한 곳에 거리를 누적해서 +1할 배열
        // 여기서는 하, 우 방향으로만 가므로 하, 우 순서를 먼저
        int[] sx = {1, 0, -1, 0};   // 하, 우, 상, 좌 탐색하기 위한 x좌표(행)
        int[] sy = {0, 1, 0, -1};   // 하, 우, 상, 좌 탐색하기 위한 y좌표(열)

        queue.offer(new Where(0, 0));   // (0,0)부터 시작
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Where p = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = p.x + sx[i];
                int ny = p.y + sy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {   // 좌표 유효성 검사
                    if (miro[nx][ny] != '0' && dist[nx][ny] == 0) {   // 갈수 있는 칸 검사
                        queue.offer(new Where(nx, ny));
                        dist[nx][ny] = dist[p.x][p.y] + 1;   // (nx,ny)칸까지 거리 계산
                    }
                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}

// 패키지안에 Point클래스가 있어서 중복이 안된다.
class Where {
    int x;
    int y;

    Where(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

