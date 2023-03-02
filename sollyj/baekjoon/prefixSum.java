package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class prefixSum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum_arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken());   // N개의 정수들 중 i번째 까지의 합을 저장하는 배열
        }

        for(int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sum_arr[j] - sum_arr[i-1]);
        }
        
    }
}

