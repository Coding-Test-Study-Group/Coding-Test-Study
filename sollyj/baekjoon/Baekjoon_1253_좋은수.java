// Baekjoon_1253_좋은수
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1253_좋은수 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);   // 오름차순 정렬

        for(int k=0; k<N; k++) {
            long find = arr[k];
            int i = 0;  // 포인터1
            int j = N-1;    // 포인터2
            long temp_sum = arr[i] + arr[j];

            while(i < j) {
                if(temp_sum > find) {
                    temp_sum = temp_sum - arr[j] + arr[--j];
                } else if(temp_sum < find){
                    temp_sum = temp_sum - arr[i] + arr[++i];
                } else {
                    if(k != i && k != j) {  // 자기 자신을 좋은 수 만들기에 포함하면 안된다.
                        answer++;
                        break;
                    } else if(k == i){  // 예외처리
                        temp_sum = temp_sum - arr[i] + arr[++i];
                    } else if(k == j){  // 예외처리
                        temp_sum = temp_sum - arr[j] + arr[--j];
                    }
                }
            }   
        }

        System.out.print(answer);
    }
}
