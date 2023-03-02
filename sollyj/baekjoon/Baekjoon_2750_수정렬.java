// Baekjoon_2750_수정렬
package sollyj.baekjoon;

import java.io.*;

public class Baekjoon_2750_수정렬 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int M = N-1; // 정렬되지 않은 영역 개수
        while(M != 0) {
            int swapCnt = 0; // swap한 횟수

            for(int i=0; i<M; i++) {
                int temp;   // swap할때 쓰일 임시변수
                
                if(arr[i] > arr[i+1]) { // 앞의 수가 더 크면 swap
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    swapCnt++;
                }
            }
            // swap을 한번도 안했다는 뜻은 정렬이 다 됐단 뜻
            if(swapCnt == 0)    break;

            M--;
        }

        for(int i=0; i<N; i++) {
            System.out.println(arr[i]);
        }
    }
}
