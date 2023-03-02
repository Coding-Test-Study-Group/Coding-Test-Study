package sollyj.baekjoon;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Baekjoon_11286_절댓값힙 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();

        // 우선순위 큐 구현
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int first = Math.abs(a);
            int second = Math.abs(b);
            if(first == second) // 같으면 음수를 먼저 뺀다.
                return (a > b ? 1 : -1);
            else    // 다르면 절댓값 크기 순서대로 뺀다.
                return first - second;
        });

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0)  {   // 큐작업
                if(queue.isEmpty()){
                    bf.append("0\n");
                } else {
                    bf.append(queue.poll() + "\n");
                }
            } else {
                queue.add(input);
            }
        }
        System.out.println(bf.toString());
    }
}