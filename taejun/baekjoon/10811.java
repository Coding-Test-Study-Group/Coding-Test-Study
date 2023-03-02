package taejun.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i=1; i<=N; i++) {
            arr[i-1] = i;
        }

        for(int idx=0; idx<M; idx++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            int[] tmp = new int[j-i+1];
            int ridx = 0;
            for(int r=j; r>=i; r--) {
                tmp[ridx] = arr[r];
                ridx++;
            }
            ridx = i;
            for(int r : tmp) {
                arr[ridx] = r;
                ridx++;
            }
        }
        for(int res : arr) {
            bw.write(res + " ");
        }
               
        bw.flush();
        bw.close();
        br.close();
    }
}
