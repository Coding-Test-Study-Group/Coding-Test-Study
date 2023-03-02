// Baekjoon_10815_숫자카드
package sollyj.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10815_숫자카드 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] cards = new int[N];
            for(int i=0; i<N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cards);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                if(binSearch(Integer.parseInt(st.nextToken()), cards))  sb.append(1 + " ");
                else sb.append(0 + " ");
            }

            System.out.println(sb.toString());
            br.close();
        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static boolean binSearch(int search, int[] array) {
        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;   // 배열의 중간 인덱스

            if(array[mid] == search)   return true;
            else if(array[mid] < search) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}