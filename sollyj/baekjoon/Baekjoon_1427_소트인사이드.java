// Baekjoon_1427_소트인사이드
package sollyj.baekjoon;

import java.io.*;

public class Baekjoon_1427_소트인사이드 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = new String(br.readLine());
        int len = N.length();
        int[] arr = new int[len];

        for(int i=0; i<len; i++) {
            arr[i] = Integer.parseInt(N.substring(i, i+1));
        }

        // 선택정렬 (내림차순)
        for(int i=0; i<len; i++) {
            int maxInd = i; 

            // 최댓값 인덱스 찾기
            for(int j=i; j<len; j++) {  
                if(arr[j] > arr[maxInd]) {
                    maxInd = j;
                }
            }

            // 남은 정렬 부분에서 제일 앞 값과 최댓값을 swap 
            if(arr[i] < arr[maxInd]) {
                int temp = arr[i];
                arr[i] = arr[maxInd];
                arr[maxInd] = temp;
            }
        }

        for(int i=0; i<len; i++) {
            System.out.print(arr[i]);
        }
    }
}