// Baekjoon_1158_요세푸스
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1158_요세푸스 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            StringBuffer sb = new StringBuffer();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=1; i<=N; i++) {   // 큐에 1부터 N까지 넣기
                queue.add(i);
            }

            sb.append("<");
            while(queue.size() > 1) {
                int i = 0;   // K번째를 알기 위한 변수

                while(++i < K) {
                    int reAdd = queue.poll();
                    queue.add(reAdd);
                }

                if(i == K) {
                    sb.append(queue.poll() + ", ");
                }
            }
            sb.append(queue.poll() + ">");

            System.out.println(sb.toString());
        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}