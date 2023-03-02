package sollyj.baekjoon;

import java.io.*;

public class Baekjoon_1614_영식이의손가락 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long f = Long.parseLong(br.readLine());
        long f_cnt = Long.parseLong(br.readLine());
        long result_cnt = 0;

        if(f == 1 || f == 5) {
            result_cnt = (f-1) + (8*f_cnt);
        } else if(f == 2) {
            result_cnt = 1+(f_cnt/2)*8 + (f_cnt%2)*6;   // 짝수일때와 홀수일때
        } else if(f == 4) {
            result_cnt = 3+(f_cnt/2)*8 + (f_cnt%2)*2;
        } else {
            result_cnt = 2 + (4*f_cnt);
        }
        System.out.println(result_cnt);
    }
}
