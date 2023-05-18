package jiWoo.프로그래머스;
import java.util.*;
public class 프로그래머스_무인도여행 {
    static boolean [][] visited;
    static char [][] map;
    static int w, h;
    public int[] solution(String[] maps) {
        int[] answer = {-1};
        h = maps.length;
        w = maps[0].length();
        // 무인도 방문 체크하기 위하여
        visited = new boolean[h][w];
        // 정답 넣기
        ArrayList<Integer> list = new ArrayList<>();

        // maps를 char 이차원 배열로 바꾸기
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = maps[i].toCharArray();

        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                if (map[i][j] != 'X' && !visited[i][j]) {
                    list.add(findMax(i, j));
                }
            }
        }
        int size = list.size();
        if (size > 0) {
            Collections.sort(list);
            answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = list.get(i);
            }
        }

        System.out.println(list);

        return answer;
    }

    public int findMax(int x, int y) {

        int max = (map[x][y] - '0');
        // 상하좌우
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >=0 && ny >= 0 && nx < h && ny < w && map[nx][ny] != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                    max += (map[nx][ny] - '0');
                }
            }
        }
        return max;
    }
}
