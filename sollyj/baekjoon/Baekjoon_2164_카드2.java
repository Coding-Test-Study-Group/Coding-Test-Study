package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2164_카드2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        // 큐에 1부터 N까지 넣기
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        while(queue.size() >= 2) {
            queue.poll();
            int en = queue.poll();
            queue.add(en);
        }   

        System.out.println(queue.poll());   // 나머지 하나 출력
    }
}
