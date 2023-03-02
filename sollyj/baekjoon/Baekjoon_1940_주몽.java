// Baekjoon_1940_주몽

package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1940_주몽 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {    
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : arr) {  // 배열 순회
            int one = i;
            int two = M-one;    
            // one + two = M이 되는 two가 배열안에 있는지 확인
            if(Arrays.stream(arr).anyMatch(x -> x == two))    answer++;
        }        

        System.out.print(answer/2); // 배열을 순회할때 one이 two값이 될때 중복으로 카운트 되므로 나누기2
    }
}
