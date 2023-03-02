// baekjoon 2018 수들의합5
package sollyj.baekjoon;

import java.io.*;

public class Baekjoon_2018_수들의합5 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int start = 1;  // 처음시작 수
        int end = 1;    // 마지막 수
        int sum = 1;
    
        while(end <= N) {
            if(sum < N) {
                sum = sum + (++end);
            } else if(sum > N) {
                sum = sum - (start++);
            } else {
                answer++;
                sum = sum + (++end);
            }
        }   

        System.out.print(answer);
    }
}
