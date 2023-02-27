package taejun.baekjoon;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }
        int temp = 0;

        for(int idx=0; idx<M; idx++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            temp = 0;
        }
        for(int ball : arr) {
            bw.write(ball + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
