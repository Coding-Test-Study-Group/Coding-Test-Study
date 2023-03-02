// Baekjoon_10989_수정렬3
package sollyj.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_10989_수정렬3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001]; // 1~10000
        
        for(int i = 0; i < N; i++) {
            // 입력한 값을 인덱스에 둔다.
            // 중복된 값이 있을 수 있으니 +1씩 한다.
            cnt[Integer.parseInt(br.readLine())]++;
        }

        // cnt배열을 순회하면서 인덱스를 출력하면 자동으로 오름차순 정렬이 된다.
        for(int i=1; i<10001; i++) {
            while(cnt[i] > 0) {
                bf.append(i).append('\n');
                cnt[i]--;
            } 
        }

        System.out.print(bf);
    }
}
