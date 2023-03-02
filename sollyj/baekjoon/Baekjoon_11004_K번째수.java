// Baekjoon_11004_K번째수
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11004_K번째수 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quick(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    private static void quick(int[] array, int start, int end, int k) {
        if(start < end) {
            int pivot = partition(array, start, end);

            if(pivot == k)  return;
            // k가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
            else if(k < pivot)  quick(array, start, pivot-1, k);
            // k가 pivot보다 크면 오른쪽 그룹만 정렬 수행
            else   quick(array, pivot+1, end, k);
        }
    }

    private static int partition(int[] array, int start, int end){
        if(start + 1 == end) {    // 원소가 2개면
            if(array[start] > array[end])
                swap(array, start, end);
            return end;
        }

        int medium = (start + end) / 2;   // 중간에 있는 값을 pivot으로 설정
        // pivot을 첫번째 위치로 옮김 (반복문 편하게 돌리기 위해서)
        swap(array, medium, start); 
        int pivot = array[start];

        int i = start + 1;  // 첫번째 값은 pivot이니까 그다음 값부터 순회
        int j = end;
        
        while(i <= j) {
            // pivot보다 작은수가 나올때 까지 --
            while(array[j] > pivot && j > 0) {
                j--;
            }
            // pivot보다 큰수가 나올때 까지 ++
            while(array[i] < pivot && i < array.length-1) {
                i++;
            }
            if(i <= j) {
                swap(array, i++, j--);
            }
        }

        // pivot 인덱스를 리턴
        array[start] = array[j];
        array[j] = pivot;
        return j;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
