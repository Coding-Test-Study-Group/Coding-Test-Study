// Baekjoon_11399_ATM
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11399_ATM {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입정렬 (오름차순)
        for(int i=1; i<N; i++) {    
            int insert_value = P[i];    // 삽입할 값
            int insert_point = i;   // 삽입할 위치

            // 삽입할 위치 찾기
            for(int k=i-1; k>=0; k--) {    
                if(P[k] <= P[i]){
                    insert_point = k+1;
                    break;
                }
                if(k == 0)  insert_point = 0;
            }

            // insert_point전까지 앞의 값을 뒤의 값으로 대입하고 즉, 뒤로 밀고
            for(int j=i; j>insert_point; j--) {
                P[j] = P[j-1];
            }
            // insert_point에 insert_value 삽입
            P[insert_point] = insert_value;
        }

        int[] sum = new int[N];
        sum[0] = P[0];
        for(int i=1; i<N; i++) {
            sum[i] = sum[i-1] + P[i];
        }

        for(int i=0; i<N; i++) {
            result += sum[i];
        }

        System.out.println(result);
    }    
}
