// Baekjoon_1920_수찾기
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1920_수찾기 {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(binarySearch(A, target))
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        br.close();
        System.out.print(sb.toString());
    }

    private static boolean binarySearch(int[] A, int x) {
        int start = 0;
        int end = A.length-1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(A[mid] == x)   return true;
            else if(A[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}