import java.util.*;

public class 백준_1074번_Z {
    static int cnt;
    static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 2^N 차원 배열
        r = sc.nextInt();
        c = sc.nextInt();
        cnt = -1;
        findZ(N, 0, 0);
    }

    private static void findZ(int num, int sr, int sc) {

        // 정답
        if (num == 0 && sr == r && sc == c) {
            cnt++;
            System.out.println(cnt);
            return;
        }
        // 1구역
        if (sr + Math.pow(2, num - 1) > r && sc + Math.pow(2, num - 1) > c) { // 포함
            findZ(num - 1, sr, sc);
            return;
        } else
            cnt += Math.pow(Math.pow(2, num - 1), 2);
        // 2구역
        if (sr + Math.pow(2, num - 1) > r && sc + Math.pow(2, num - 1) <= c) { // 포함
            findZ(num - 1, sr, sc + (int) Math.pow(2, num - 1));
            return;
        } else
            cnt += Math.pow(Math.pow(2, num - 1), 2);
        // 3구역
        if (sr + Math.pow(2, num - 1) <= r && sc + Math.pow(2, num - 1) > c) { // 포함
            findZ(num - 1, sr + (int) Math.pow(2, num - 1), sc);
            return;
        } else
            cnt += Math.pow(Math.pow(2, num - 1), 2);
        // 4구역
        if (sr + Math.pow(2, num - 1) <= r && sc + Math.pow(2, num - 1) <= c) { // 포함
            findZ(num - 1, sr + (int) Math.pow(2, num - 1), sc + (int) Math.pow(2, num - 1));
            return;
        } else
            cnt += Math.pow(Math.pow(2, num - 1), 2);
        /*
         * 
         * if (sr + Math.pow(2, num) - 1 < r) { // 지나는 가는데 목표가 포함 안했다면 그냥 탐색 안하고 값만 플러스
         * System.out.println("탐색 안하고 더 해 r: " + sr + "   c:" + sc);
         * cnt += Math.pow(Math.pow(2, num), 2);
         * return;
         * } else if (sc > c) {// 목표 구간보다 뒤에 있으면 탐색안한다.
         * System.out.println("탐색 안 해 r: " + sr + "   c:" + sc);
         * return;
         * }
         * System.out.println("탐색 해 r: " + sr + "   c:" + sc);
         * if (num > 0) { // num은 2^num차원 배열, (sr,sc)는 시작부분
         * 
         * findZ(num - 1, sr, sc); // 시작
         * findZ(num - 1, sr, sc + (int) Math.pow(2, num - 1)); // 2번째는 오른쪽으로 2의
         * (num-1)제곱 만큼 이동해서 그 시작점과 num을 다시 재귀로
         * // 넣어준다. 아래도 마찬가지
         * findZ(num - 1, sr + (int) Math.pow(2, num - 1), sc); // 3번째는 시작점에서 아래로 2의
         * (num-1)제곱 만큼 이동
         * findZ(num - 1, sr + (int) Math.pow(2, num - 1), sc + (int) Math.pow(2, num -
         * 1)); // 4번째는 시작점의 오른쪽과 아래로 2의
         * // (num-1)제곱 만큼 이동
         * } else if (num == 0) { // num이 0일 때는 한 칸이므로 방문 숫자를 늘려주는데 찾을 r과 c이면 출력
         * cnt++;
         * if (sr == r && sc == c) {
         * System.out.println(cnt);
         * return;
         * }
         * }
         */
    }
}