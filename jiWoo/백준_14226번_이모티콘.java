

import java.util.*;

public class 백준_14226번_이모티콘 {
    static int S;
    static boolean check[][] = new boolean[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        // now[0] 은 화면의 값, now[1]은 클립보드의 값, now[3] 은 시간
        Integer now[] = new Integer[3]; 
        now[0] = 1;
        now[1] = 0;
        now[2] = 0;
        Queue<Integer[]> que = new LinkedList<>();
        check[1][0] = true;
        que.add(now);

        BFS(que);

    }

    private static void BFS(Queue<Integer[]> que) { // 넣을 때 check로 방문 확인
        while (!que.isEmpty()) {
            Integer[] now = que.poll();
            if (now[0] != S) { // 답이 아니면
                if (now[0] > 1 && !check[now[0] - 1][now[1]]) { // 삭제 현재 값이 1보다 크고 삭제한 값을 방문하지 않았을 때
                    Integer[] add = { now[0] - 1, now[1], now[2] + 1 };

                    check[now[0] - 1][now[1]] = true;
                    que.add(add);
                }
                // 클립보드를 화면으로 붙여넣기, 클립보드가 0보다 크고 정답은 1000 이하이므로 들어갈 값이 1000이하일 때+ 방문 엑스일 때
                if (now[1] > 0 && now[0] + now[1] <= 1000 &&
                        !check[now[0] + now[1]][now[1]]) {
                    Integer[] add = { now[0] + now[1], now[1], now[2] + 1 };
                    check[now[0] + now[1]][now[1]] = true;
                    que.add(add);
                }
                // 화면을 복사하기, 현재의 값과 클립보드 값이 다를 때 , 방문 엑스일 때
                if (now[0] != now[1] && !check[now[0]][now[0]]) {
                    Integer[] add = { now[0], now[0], now[2] + 1 };
                    check[now[0]][now[0]] = true;
                    que.add(add);
                }

            } else { // S인 경우
                System.out.println(now[2]);
                break;
            }
        }
    }
}
