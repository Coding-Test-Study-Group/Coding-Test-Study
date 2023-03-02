package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class prefixSum_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sum_arr = new int[N+1][N+1];
        // sum_arr에 (i,k)까지의 누적합 넣기
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = 0;    // i번째 행에서 입력 받는 값의 누적합 저장할 임시변수
            for(int k=1; k<=N; k++) {
                tmp += Integer.parseInt(st.nextToken());
                sum_arr[i][k] = tmp + sum_arr[i-1][k];
            }
        }


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sum_arr[x2][y2] - sum_arr[x1-1][y2] - sum_arr[x2][y1-1] + sum_arr[x1-1][y1-1]);
        }
    }
}
