package jiWoo.백준;

import java.io.*;
import java.util.*;

public class 백준_요세푸스문제 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Queue에 1 ~ N 까지 넣기
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        // cnt = K 일 때 정답 리스트에 넣기
        ArrayList<Integer> answer = new ArrayList<>();
        // que가 빌 때 까지 반복
        int cnt = 0;
        while (!que.isEmpty()) {
            cnt++;
            // 앞에 있는 수 꺼내기
            int now = que.poll();
            // cnt = K일 때는 정답에 넣고 아니라면 다시 큐에 넣기
            if (cnt == K){
                answer.add(now);
                cnt = 0;
            }
            else que.add(now);
        }

        // 정답 출력
        System.out.print("<");
        for (int i = 0; i < N - 1; i++) {
            System.out.print(answer.get(i) + ", ");
        }
        System.out.print(answer.get(N-1) + ">");
    }
}
